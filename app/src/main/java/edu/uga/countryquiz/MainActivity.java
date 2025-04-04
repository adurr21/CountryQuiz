package edu.uga.countryquiz;

import android.content.ContentValues;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import edu.uga.countryquiz.content.Quiz;
import edu.uga.countryquiz.fragments.PastQuizzesFragment;
import edu.uga.countryquiz.fragments.QuizFragment;
import edu.uga.countryquiz.fragments.SplashScreen;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "edu.uga.countryquiz";
    private static final String STATE_KEY_ACTIVE_QUIZ = "active_quiz";
    private static final String STATE_KEY_CURRENT_FRAGMENT = "current_fragment";
    private static final String STATE_KEY_USER_ANSWERS = "user_answers";
    public static DatabaseHelper dbHelper;
    public SQLiteDatabase db;
    protected static AssetManager assetManager;
    private Quiz activeQuiz = null;
    private String currentFragmentTag = "splash";
    private ArrayList<String> userAnswers = null;
    private int currentQuestionPosition = 0;

    /**
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(LOG_TAG, "MainActivity: onCreate() called");
        assetManager = getAssets();
        dbHelper = DatabaseHelper.getInstance(getApplicationContext());
        db = dbHelper.getWritableDatabase();

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        if (savedInstanceState != null) {
            restoreAppState(savedInstanceState); // Restore state if available
        } else { // Load splash screen if no fragment exists
            if (getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView) == null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragmentContainerView, new SplashScreen())
                        .commit();
            }
        }
    }

    /**
     * Restores app state from saved instance bundle.
     * @param savedInstanceState Bundle containing the saved state.
     */
    private void restoreAppState(Bundle savedInstanceState) {
        currentFragmentTag = savedInstanceState.getString(STATE_KEY_CURRENT_FRAGMENT, "splash");
        if (savedInstanceState.containsKey(STATE_KEY_ACTIVE_QUIZ)) {
            activeQuiz = (Quiz) savedInstanceState.getSerializable(STATE_KEY_ACTIVE_QUIZ);
        }
        if (savedInstanceState.containsKey(STATE_KEY_USER_ANSWERS)) {
            userAnswers = savedInstanceState.getStringArrayList(STATE_KEY_USER_ANSWERS);
        }
        currentQuestionPosition = savedInstanceState.getInt("current_question_position", 0);
        if (currentFragmentTag.equals("quiz") && activeQuiz != null) {
            Fragment fragment = QuizFragment.newInstance(activeQuiz);
            Bundle args = new Bundle();
            args.putInt("current_position", currentQuestionPosition);
            if (userAnswers != null) {
                args.putStringArrayList("saved_answers", userAnswers);
            }
            fragment.setArguments(args);
            // Replace with quiz fragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, fragment)
                    .commit();
        } else if (currentFragmentTag.equals("past_quizzes")) {
            // Replace with past quizzes fragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new PastQuizzesFragment())
                    .commit();
        } else {
            // Replace with splash screen
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, new SplashScreen())
                    .commit();
        }
    }

    /**
     * Saves the current app state into a bundle.
     * @param outState Bundle to save the state into.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_KEY_CURRENT_FRAGMENT, currentFragmentTag); // Save fragment tag
        if (activeQuiz != null) {
            outState.putSerializable(STATE_KEY_ACTIVE_QUIZ, activeQuiz); // Save active quiz
        }
        if (userAnswers != null) {
            outState.putStringArrayList(STATE_KEY_USER_ANSWERS, userAnswers); // Save user answers
        }
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        if (currentFragment instanceof QuizFragment) {
            QuizFragment quizFragment = (QuizFragment) currentFragment;
            int position = quizFragment.getCurrentPosition();
            outState.putInt("current_question_position", position); // Save current question position
        }
        Log.d(LOG_TAG, "onSaveInstanceState: Save app state");
    }

    /**
     * Called when activity is paused.
     */
    @Override
    protected void onPause() {
        super.onPause();

        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        if (currentFragment instanceof QuizFragment) { // if pausing during a quiz
            QuizFragment quizFragment = (QuizFragment) currentFragment;
            userAnswers = quizFragment.getUserAnswers();
            currentQuestionPosition = quizFragment.getCurrentPosition();
            currentFragmentTag = "quiz";
        } else if (currentFragment instanceof PastQuizzesFragment) { // if pausing in past quizzes fragment
            currentFragmentTag = "past_quizzes";
        }

        Log.d(LOG_TAG, "onPause: Captured app state");
    }

    /**
     * Called when the activity resumes.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume: Resumed app");
    }

    /**
     * Retrieves the records from the database.
     * @param table The name of the table.
     * @return A list of records as strings.
     */
    public List<String> getAllRecords(String table) {
        List<String> records = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase(); // Get readable database

        if (table.equals(DatabaseHelper.COUNTRY_TABLE_NAME)) {
            Cursor cursor = db.query(
                    DatabaseHelper.COUNTRY_TABLE_NAME,
                    new String[]{DatabaseHelper.COUNTRY_COLUMN_NAME, DatabaseHelper.COUNTRY_COLUMN_CONTINENT},
                    null, null, null, null, null
            );

            if (cursor.moveToFirst()) {
                do {
                    String record = "ID: " + cursor.getString(0) +
                            ", Name: " + cursor.getString(1) +
                            ", Age: " + cursor.getString(2);
                    records.add(record);
                } while (cursor.moveToNext());
            }

            cursor.close();
            db.close();
        } else if (table.equals(DatabaseHelper.QUIZZES_TABLE_NAME)) {
            // Implement method to retrieve all quizzes.
        }

        return records;
    }

    /**
     * Called when activity stops.
     */
    @Override
    protected void onStop() {
        super.onStop();
        db.close();
    }

    /**
     * Displays the past quizzes fragment.
     */
    public void viewQuizResults() {
        Fragment fragment = new PastQuizzesFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment).addToBackStack("main");
        transaction.commit();
        currentFragmentTag = "past_quizzes";
    }

    /**
     * Displays the quiz fragment.
     */
    public void startQuiz() {
        Quiz newQuiz = new Quiz();
        Fragment fragment = QuizFragment.newInstance(newQuiz);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment)
                .addToBackStack("main")
                .commit();
        activeQuiz = newQuiz; // Set active quiz
        currentFragmentTag = "quiz";
        userAnswers = new ArrayList<>(6); // Initialize user answers list
        for (int i = 0; i < 6; i++) {
            userAnswers.add(null);
        }
    }
}