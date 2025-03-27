package edu.uga.countryquiz.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import edu.uga.countryquiz.R;
import edu.uga.countryquiz.MainActivity;
import edu.uga.countryquiz.content.Quiz;
import edu.uga.countryquiz.content.QuizQuestion;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment {

    private static final String ARG_QUIZ = "quiz";
    private static final String ARG_QUESTION_INDEX = "questionIndex";
    private Quiz quiz;
    private int currentQuestionIndex;
    private TextView questionText;
    private RadioGroup continentChoices;
    private RadioButton choice1, choice2, choice3;

    public QuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param quiz Parameter 1.
     * @param questionIndex Parameter 2.
     * @return A new instance of fragment QuizFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuizFragment newInstance(Quiz quiz, int questionIndex) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_QUIZ, quiz);
        args.putInt(ARG_QUESTION_INDEX, questionIndex);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            quiz = (Quiz) getArguments().getSerializable(ARG_QUIZ);
            currentQuestionIndex = getArguments().getInt(ARG_QUESTION_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize UI elements
        questionText = view.findViewById(R.id.questionText);
        continentChoices = view.findViewById(R.id.continentChoices);
        choice1 = view.findViewById(R.id.choice1);
        choice2 = view.findViewById(R.id.choice2);
        choice3 = view.findViewById(R.id.choice3);

        // Load the current question
        loadQuestion();
    }

    private void loadQuestion() {
        QuizQuestion currentQuestion = quiz.quizQuestions[currentQuestionIndex];

        // Set the question text
        questionText.setText("Name the continent on which " + currentQuestion.countryName + " is located");

        // Create a list of choices and shuffle them
        ArrayList<String> choices = new ArrayList<>();
        choices.add(currentQuestion.correctContinent);
        choices.add(currentQuestion.wrongContinentOne);
        choices.add(currentQuestion.wrongContinentTwo);
        Collections.shuffle(choices);

        // Set the radio button texts
        choice1.setText("A. " + choices.get(0));
        choice2.setText("B. " + choices.get(1));
        choice3.setText("C. " + choices.get(2));

        Log.d(MainActivity.LOG_TAG, "Loaded question " + (currentQuestionIndex + 1) + " for " + currentQuestion.countryName);
    }
}