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
    // TODO: Rename and change types and number of parameters
    public static QuizResultsFragment newInstance(Quiz quiz, ArrayList<String> answers) {
        QuizResultsFragment fragment = new QuizResultsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_QUIZ, quiz);
        args.putStringArrayList(ARG_ANSWERS, answers);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            quiz = (Quiz) getArguments().getSerializable(ARG_QUIZ);
            userAnswers = getArguments().getStringArrayList(ARG_ANSWERS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_results, container, false);
    }

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
    }

    private class ViewQuizResults implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ((MainActivity)getActivity()).viewQuizResults();
        }
    }

    private class ReturnHome implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Fragment splashScreen = new SplashScreen();
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, splashScreen)
                    .commit();
        }
    }

    private class StartNewQuiz implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ((MainActivity)getActivity()).startQuiz();
        }
    }

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