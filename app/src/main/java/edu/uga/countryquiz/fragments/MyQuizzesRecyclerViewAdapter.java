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
import edu.uga.countryquiz.placeholder.PlaceholderContent.PlaceholderItem;
import edu.uga.countryquiz.databinding.FragmentPastQuizzesBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyQuizzesRecyclerViewAdapter extends RecyclerView.Adapter<MyQuizzesRecyclerViewAdapter.ViewHolder> {

    private final List<Quiz> mValues;

    public MyQuizzesRecyclerViewAdapter(List<Quiz> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_past_quizzes, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(holder.mItem.stringDate);
        Log.d(MainActivity.LOG_TAG, "RecyclerAdapter - idView Text: " + holder.mItem.score);
        holder.mContentView.setText(String.valueOf((int)holder.mItem.score) + "%");
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public Quiz mItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mIdView = itemView.findViewById(R.id.item_number);
            mContentView = itemView.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}