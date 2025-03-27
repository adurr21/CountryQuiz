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

import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

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

    public static final String LOG_TAG = "edu.uga.countryquiz";

    private static final String ARG_QUIZ = "quiz";
    private Quiz quiz;
    private ViewPager2 quizViewPager;
    private ArrayList<String> userAnswers;

    public QuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param quiz Parameter 1.
     * @return A new instance of fragment QuizFragment.
     */
    public static QuizFragment newInstance(Quiz quiz) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_QUIZ, quiz);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            quiz = (Quiz) getArguments().getSerializable(ARG_QUIZ);
        }
        userAnswers = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            userAnswers.add(null);
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

        quizViewPager = view.findViewById(R.id.quizViewPager);
        quizViewPager.setAdapter(new QuizPagerAdapter(this));
        quizViewPager.setUserInputEnabled(true); // Allow swiping
    }

    private class QuizPagerAdapter extends FragmentStateAdapter {
        public QuizPagerAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return QuizQuestionFragment.newInstance(quiz, position, userAnswers);
        }

        @Override
        public int getItemCount() {
            return 6; // Back to 6 questions
        }
    }

    public void showResults() {
        Fragment fragment = QuizResultsFragment.newInstance(quiz, userAnswers);
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .addToBackStack("quiz")
                .commit();
        Log.d(LOG_TAG, "showResults() called - transitioning to QuizResultsFragment");
    }

}