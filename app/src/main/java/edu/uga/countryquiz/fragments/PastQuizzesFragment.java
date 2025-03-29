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
import edu.uga.countryquiz.content.Quiz;
import edu.uga.countryquiz.content.Quizzes;
import edu.uga.countryquiz.placeholder.PlaceholderContent;

/**
 * A fragment representing a list of Items.
 */
public class PastQuizzesFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private Button returnHomeButton, startNewQuizButton;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PastQuizzesFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static PastQuizzesFragment newInstance(int columnCount) {
        PastQuizzesFragment fragment = new PastQuizzesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_past_quizzes_list, container, false);

        // Set the adapter
        if (true) {
            Context context = view.getContext();
            RecyclerView recyclerView = view.findViewById(R.id.list);
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyQuizzesRecyclerViewAdapter(Quizzes.getQuizzes()));

            returnHomeButton = view.findViewById(R.id.returnHomeButton);
            returnHomeButton.setOnClickListener(v -> {
                Fragment splashScreen = new SplashScreen();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainerView, splashScreen)
                        .commit();
            });

            startNewQuizButton = view.findViewById(R.id.startNewQuizButton);
            startNewQuizButton.setOnClickListener(v -> {
                ((MainActivity)getActivity()).startQuiz();
            });

        }
        return view;
    }
}