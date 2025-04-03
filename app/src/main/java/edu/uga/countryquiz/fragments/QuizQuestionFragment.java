package edu.uga.countryquiz.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import edu.uga.countryquiz.R;
import edu.uga.countryquiz.content.Quiz;
import edu.uga.countryquiz.content.QuizQuestion;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizQuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizQuestionFragment extends Fragment {

    private static final String ARG_QUIZ = "quiz";
    private static final String ARG_POSITION = "position";
    private static final String ARG_ANSWERS = "answers";
    private static final String LOG_TAG = "edu.uga.countryquiz";

    private Quiz quiz;
    private int position;
    private ArrayList<String> userAnswers;

    private TextView questionText;
    private RadioGroup continentChoices;
    private RadioButton choice1, choice2, choice3;

    public QuizQuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param quiz Parameter 1.
     * @param position Parameter 2.
     * @param answers Parameter 3.
     * @return A new instance of fragment QuizQuestionFragment.
     */
    public static QuizQuestionFragment newInstance(Quiz quiz, int position, ArrayList<String> answers) {
        QuizQuestionFragment fragment = new QuizQuestionFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_QUIZ, quiz);
        args.putInt(ARG_POSITION, position);
        args.putStringArrayList(ARG_ANSWERS, answers);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            quiz = (Quiz) getArguments().getSerializable(ARG_QUIZ);
            position = getArguments().getInt(ARG_POSITION);
            userAnswers = getArguments().getStringArrayList(ARG_ANSWERS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        questionText = view.findViewById(R.id.questionText);
        continentChoices = view.findViewById(R.id.continentChoices);
        choice1 = view.findViewById(R.id.choice1);
        choice2 = view.findViewById(R.id.choice2);
        choice3 = view.findViewById(R.id.choice3);
        loadQuestion();

        Log.d(LOG_TAG, "QuizQuestionFragment: Displayed position " + position);

        continentChoices.setOnCheckedChangeListener((group, checkedId) -> {
            String selectedAnswer = null;
            if (checkedId == R.id.choice1) {
                selectedAnswer = choice1.getText().toString().substring(3);
            } else if (checkedId == R.id.choice2) {
                selectedAnswer = choice2.getText().toString().substring(3);
            } else if (checkedId == R.id.choice3) {
                selectedAnswer = choice3.getText().toString().substring(3);
            }
            userAnswers.set(position, selectedAnswer);
        });
    }

    private void loadQuestion() {
        QuizQuestion currentQuestion = quiz.quizQuestions[position];
        questionText.setText((position + 1) + ". Name the continent on which " +
                currentQuestion.countryName + " is located");

        ArrayList<String> choices = new ArrayList<>();
        choices.add(currentQuestion.correctContinent);
        choices.add(currentQuestion.wrongContinentOne);
        choices.add(currentQuestion.wrongContinentTwo);
        Collections.shuffle(choices);

        choice1.setText("A. " + choices.get(0));
        choice2.setText("B. " + choices.get(1));
        choice3.setText("C. " + choices.get(2));
    }
}