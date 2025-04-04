package edu.uga.countryquiz.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.uga.countryquiz.MainActivity;
import edu.uga.countryquiz.R;
import edu.uga.countryquiz.content.Quizzes;

/**
 * A fragment that displays a list of past quizzes in a RecyclerView. Provides buttons
 * to return to the home screen or start a new quiz.
 */
public class PastQuizzesFragment extends Fragment {

    // Argument key for specifying the number of columns
    private static final String ARG_COLUMN_COUNT = "column-count";
    // Number of columns in the RecyclerView layout, defaults to 1
    private int mColumnCount = 1;
    // Button to return to the home screen
    private Button returnHomeButton;
    // Button to start a new quiz
    private Button startNewQuizButton;

    /**
     * Mandatory empty constructor required by the fragment manager to instantiate
     * the fragment, e.g., during screen orientation changes.
     */
    public PastQuizzesFragment() {
    }

    /**
     * Called to initialize the fragment. Retrieves the column count from arguments
     * if provided.
     *
     * @param savedInstanceState if non-null, this fragment is being re-constructed
     *                           from a previous saved state
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    /**
     * Inflates the fragment's layout, sets up the RecyclerView with past quizzes,
     * and configures button click listeners.
     *
     * @param inflater           the LayoutInflater to inflate the layout
     * @param container          the parent ViewGroup
     * @param savedInstanceState if non-null, this fragment is being re-constructed
     *                           from a previous saved state
     * @return the inflated view for the fragment
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_past_quizzes_list, container, false);

        // Set up the RecyclerView
        Context context = view.getContext();
        RecyclerView recyclerView = view.findViewById(R.id.list);
        if (mColumnCount <= 1) {
            // Use a linear layout for single column
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            // Use a grid layout for multiple columns
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
        // Set the adapter with the list of past quizzes
        recyclerView.setAdapter(new MyQuizzesRecyclerViewAdapter(Quizzes.getQuizzes()));

        // Configure the return home button
        returnHomeButton = view.findViewById(R.id.returnHomeButton);
        returnHomeButton.setOnClickListener(v -> {
            Fragment splashScreen = new SplashScreen();
            getParentFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainerView, splashScreen)
                    .commit();
        });

        // Configure the start new quiz button
        startNewQuizButton = view.findViewById(R.id.startNewQuizButton);
        startNewQuizButton.setOnClickListener(v -> {
            ((MainActivity)getActivity()).startQuiz();
        });

        return view;
    }
}