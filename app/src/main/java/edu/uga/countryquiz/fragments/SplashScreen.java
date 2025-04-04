package edu.uga.countryquiz.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import edu.uga.countryquiz.DatabaseHelper;
import edu.uga.countryquiz.MainActivity;
import edu.uga.countryquiz.R;
import edu.uga.countryquiz.content.Quiz;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SplashScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SplashScreen extends Fragment {
    private Button startQuiz;
    private Button viewResults;
    private Activity activity;

    public SplashScreen() {
        // Required empty public constructor
    }

    /**
     * Factory method to create a new instance of this fragment
     *
     * @return A new instance of fragment SplashScreen.
     */
    public static SplashScreen newInstance() {
        SplashScreen fragment = new SplashScreen();
        Bundle args = new Bundle();
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
        Log.d(MainActivity.LOG_TAG, "SplashScreen Fragment: onCreate() called");
        super.onCreate(savedInstanceState);
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
        return inflater.inflate(R.layout.fragment_splash_screen, container, false);
    }

    /**
     *
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        activity = getActivity();
        startQuiz = activity.findViewById(R.id.startQuizButton);
        viewResults = activity.findViewById(R.id.viewPastButton);

        viewResults.setOnClickListener(new ViewQuizResults());
        startQuiz.setOnClickListener(new StartQuiz());
    }

    /**
     * Handle viewing quiz results.
     * Called when the viewResults button is clicked.
     */
    private class ViewQuizResults implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ((MainActivity)getActivity()).viewQuizResults();
        }
    }

    /**
     * Handle starting a new quiz.
     * Called when the startQuiz button is clicked.
     */
    private class StartQuiz implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ((MainActivity) getActivity()).startQuiz();
        }
    }
}