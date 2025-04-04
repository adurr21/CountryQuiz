package edu.uga.countryquiz.fragments;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.uga.countryquiz.MainActivity;
import edu.uga.countryquiz.R;
import edu.uga.countryquiz.content.Quiz;

import java.util.List;

/**
 * A {@link RecyclerView.Adapter} that displays a list of {@link Quiz} objects
 * representing past quizzes in a RecyclerView. Each item shows the quiz date
 * and score percentage.
 */
public class MyQuizzesRecyclerViewAdapter extends RecyclerView.Adapter<MyQuizzesRecyclerViewAdapter.ViewHolder> {

    // List of Quiz objects to be displayed
    private final List<Quiz> mValues;

    /**
     * Constructs the adapter with a list of quizzes to display.
     *
     * @param items the list of Quiz objects to be shown in the RecyclerView
     */
    public MyQuizzesRecyclerViewAdapter(List<Quiz> items) {
        mValues = items;
    }

    /**
     * Creates a new ViewHolder by inflating the layout for a single quiz item.
     *
     * @param parent   the parent ViewGroup into which the new view will be added
     * @param viewType the type of the new view (not used in this implementation)
     * @return a new ViewHolder containing the inflated view
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_past_quizzes, parent, false);

        return new ViewHolder(view);
    }

    /**
     * Binds quiz data to the views in the ViewHolder at the specified position.
     *
     * @param holder   the ViewHolder to bind data to
     * @param position the position in the data set of the item to bind
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(holder.mItem.stringDate);
        Log.d(MainActivity.LOG_TAG, "RecyclerAdapter - idView Text: " + holder.mItem.score);
        holder.mContentView.setText(String.valueOf((int)holder.mItem.score) + "%");
    }

    /**
     * Returns the total number of quizzes in the data set.
     *
     * @return the size of the quiz list
     */
    @Override
    public int getItemCount() {
        return mValues.size();
    }

    /**
     * ViewHolder class that holds references to the views for each quiz item
     * and the corresponding Quiz object.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public Quiz mItem;

        /**
         * Constructs a ViewHolder with the given item view, initializing
         * references to the date and score TextViews.
         *
         * @param itemView the view for a single quiz item
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mIdView = itemView.findViewById(R.id.item_number);
            mContentView = itemView.findViewById(R.id.content);
        }

        /**
         * Returns a string representation of the ViewHolder, including
         * the content text.
         *
         * @return a string describing the ViewHolder
         */
        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}