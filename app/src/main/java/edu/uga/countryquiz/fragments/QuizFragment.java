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
 * A {@link Fragment} subclass that manages a quiz with multiple questions displayed in a ViewPager2.
 * Handles user answers and transitions to results upon completion.
 * Use the {@link QuizFragment#newInstance} factory method to create an instance of this fragment.
 */
public class QuizFragment extends Fragment {

    /** The logging tag used for debugging purposes. */
    public static final String LOG_TAG = "edu.uga.countryquiz";

    // Argument key for passing the Quiz object
    private static final String ARG_QUIZ = "quiz";
    // The Quiz object containing the questions
    private Quiz quiz;
    // ViewPager2 for navigating between quiz questions
    private ViewPager2 quizViewPager;
    // List to store user answers for each question
    private ArrayList<String> userAnswers;
    // Current position in the ViewPager
    private int currentPosition = 0;

    /**
     * Required empty public constructor for fragment instantiation.
     */
    public QuizFragment() {
        // Required empty public constructor
    }

    /**
     * Factory method to create a new instance of QuizFragment with the specified Quiz object.
     *
     * @param quiz the Quiz object containing the questions for this fragment
     * @return a new instance of QuizFragment
     */
    public static QuizFragment newInstance(Quiz quiz) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_QUIZ, quiz);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Initializes the fragment, setting up the Quiz object and user answers list from arguments.
     * Restores saved answers and position if provided.
     *
     * @param savedInstanceState if non-null, this fragment is being re-constructed from a previous saved state
     */
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

        if (getArguments() != null && getArguments().containsKey("saved_answers")) {
            ArrayList<String> savedAnswers = getArguments().getStringArrayList("saved_answers");
            if (savedAnswers != null && savedAnswers.size() == 6) {
                userAnswers = savedAnswers;
            }
        }

        if (getArguments() != null && getArguments().containsKey("current_position")) {
            currentPosition = getArguments().getInt("current_position", 0);
        }
    }

    /**
     * Inflates the layout for the quiz fragment.
     *
     * @param inflater the LayoutInflater to inflate the layout
     * @param container the parent ViewGroup
     * @param savedInstanceState if non-null, this fragment is being re-constructed from a previous saved state
     * @return the inflated view for the fragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }

    /**
     * Sets up the ViewPager2 with a QuizPagerAdapter and handles page changes.
     * Restores the current position if applicable.
     *
     * @param view the view created by onCreateView
     * @param savedInstanceState if non-null, this fragment is being re-constructed from a previous saved state
     */
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        quizViewPager = view.findViewById(R.id.quizViewPager);
        quizViewPager.setAdapter(new QuizPagerAdapter(this));
        quizViewPager.setUserInputEnabled(true);
        quizViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                currentPosition = position;
                if (position == 6) {
                    showResults();
                }
            }
        });

        if (currentPosition > 0 && currentPosition < 6) {
            quizViewPager.setCurrentItem(currentPosition, false);
        }
    }

    /**
     * Adapter for the ViewPager2, managing fragments for each quiz question and a placeholder for results.
     */
    private class QuizPagerAdapter extends FragmentStateAdapter {
        /**
         * Constructs the adapter with the parent fragment.
         *
         * @param fragment the parent fragment
         */
        public QuizPagerAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }

        /**
         * Creates a fragment for the given position, either a QuizQuestionFragment or a placeholder.
         *
         * @param position the position in the ViewPager
         * @return a Fragment instance for the given position
         */
        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if (position < 6) {
                return QuizQuestionFragment.newInstance(quiz, position, userAnswers);
            }
            return new Fragment(); // will be replaced by results fragment
        }

        /**
         * Returns the total number of items in the ViewPager (6 questions + 1 results page).
         *
         * @return the number of items
         */
        @Override
        public int getItemCount() {
            Log.d(LOG_TAG, "QuizFragment: getItemCount() called");
            return 7;
        }
    }

    /**
     * Transitions to the QuizResultsFragment to display the quiz results.
     */
    public void showResults() {
        Fragment fragment = QuizResultsFragment.newInstance(quiz, userAnswers);
        getParentFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, fragment)
                .addToBackStack("quiz")
                .commit();
        Log.d(LOG_TAG, "showResults() called - transitioning to QuizResultsFragment");
    }

    /**
     * Retrieves the list of user answers.
     *
     * @return the ArrayList containing user answers
     */
    public ArrayList<String> getUserAnswers() {
        return userAnswers;
    }

    /**
     * Retrieves the current position in the ViewPager.
     *
     * @return the current position
     */
    public int getCurrentPosition() {
        return currentPosition;
    }
}