package edu.uga.countryquiz.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import edu.uga.countryquiz.DatabaseHelper;
import edu.uga.countryquiz.MainActivity;
import edu.uga.countryquiz.R;
import edu.uga.countryquiz.content.Quiz;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizResultsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizResultsFragment extends Fragment {

    private static final String ARG_QUIZ = "quiz";
    private static final String ARG_ANSWERS = "answers";

    private Quiz quiz;
    private Activity activity;

    private ArrayList<String> userAnswers;
    private TextView resultsText;
    private Button homeButton, pastQuizzesButton, startNewQuizButton;
    public QuizResultsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param quiz Parameter 1.
     * @param answers Parameter 2.
     * @return A new instance of fragment QuizResultsFragment.
     */
    public static QuizResultsFragment newInstance(Quiz quiz, ArrayList<String> answers) {
        QuizResultsFragment fragment = new QuizResultsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_QUIZ, quiz);
        args.putStringArrayList(ARG_ANSWERS, answers);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     *
     * @param savedInstanceState If the fragment is being re-created from
     * a previous saved state, this is the state.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            quiz = (Quiz) getArguments().getSerializable(ARG_QUIZ);
            userAnswers = getArguments().getStringArrayList(ARG_ANSWERS);
        }
    }

    /**
     *
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_results, container, false);
    }

    /**
     *
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        activity = getActivity();
        resultsText = view.findViewById(R.id.resultsText);
        displayResults();
        homeButton = activity.findViewById(R.id.homeButton);
        pastQuizzesButton = activity.findViewById(R.id.pastQuizzesButton);
        startNewQuizButton = view.findViewById(R.id.startNewQuizButton);

        homeButton.setOnClickListener(new QuizResultsFragment.ReturnHome());
        pastQuizzesButton.setOnClickListener(new QuizResultsFragment.ViewQuizResults());
        startNewQuizButton.setOnClickListener(new StartNewQuiz());
        disableSwipeBack();
    }

    /**
     * Disables swipe-back functionality for use when at the end of the viewpager2.
     */
    private void disableSwipeBack() {
        Fragment parentFragment = getParentFragmentManager().findFragmentById(R.id.fragmentContainerView);
        if (parentFragment instanceof QuizFragment) {
            ViewPager2 viewPager = parentFragment.getView().findViewById(R.id.quizViewPager);
            if (viewPager != null) {
                viewPager.setUserInputEnabled(false); // Disable user swiping
            }
        }
    }

    /**
     * Handle viewing past quiz results.
     */
    private class ViewQuizResults implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ((MainActivity)getActivity()).viewQuizResults();
        }
    }

    /**
     * Handle returning to the splash page.
     */
    private class ReturnHome implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Fragment splashScreen = new SplashScreen();
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, splashScreen)
                    .commit();
        }
    }

    /**
     * Handle starting a new quiz.
     */
    private class StartNewQuiz implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ((MainActivity)getActivity()).startQuiz();
        }
    }

    /**
     * Displays quiz results, calculates the score, and saves to database.
     */
    private void displayResults() {
        int correctCount = 0;
        for (int i = 0; i < 6; i++) {
            if (userAnswers.get(i) != null && userAnswers.get(i).equals(quiz.quizQuestions[i].correctContinent)) {
                correctCount++;
            }
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault());
        String dateString = dateFormat.format(quiz.date);
        resultsText.setText("Quiz Results\nScore: " + correctCount + "/6\nDate: " + dateString);

        // Save result to database

        quiz.score = correctCount / 6.00;
        MainActivity.dbHelper.storeQuizResult(quiz);
    }
}