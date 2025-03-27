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

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = "edu.uga.countryquiz";


    public static DatabaseHelper dbHelper;
    public SQLiteDatabase db;

    protected static AssetManager assetManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "MainActivity: onCreate() called");

        assetManager = getAssets();

        dbHelper = new DatabaseHelper(getApplicationContext());

        db = dbHelper.getWritableDatabase();

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public List<String> getAllRecords(String table) {
        List<String> records = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

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

    @Override
    protected void onStop() {
        super.onStop();
        db.close();
    }

    public void viewQuizResults() {
        Fragment fragment = new PastQuizzesFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment).addToBackStack("main");
        transaction.commit();
    }

    public void startQuiz() {
        Quiz newQuiz = new Quiz(); // Create a new Quiz with 6 questions
        Fragment fragment = QuizFragment.newInstance(newQuiz, 0); // Start with the first question
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment)
                .addToBackStack("main")
                .commit();
    }
}