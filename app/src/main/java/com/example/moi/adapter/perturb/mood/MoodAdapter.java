package com.example.moi.adapter.perturb.mood;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.moi.R;
import com.example.moi.database.entity.Mood;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class MoodAdapter extends FirestoreRecyclerAdapter<Mood, MoodAdapter.MoodHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MoodAdapter(@NonNull FirestoreRecyclerOptions<Mood> options) {
        super(options);
    }


    @Override
    protected void onBindViewHolder(@NonNull MoodAdapter.MoodHolder holder, int position, @NonNull Mood model) {
        holder.mood.setText(model.getMood());
        holder.text.setText(model.getText());
        holder.date.setText(model.getDate());
    }

    @NonNull
    @Override
    public MoodAdapter.MoodHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mood_item,
                viewGroup, false);
        return new MoodAdapter.MoodHolder(v);
    }

    public void deleteItem(int position) {
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class MoodHolder extends RecyclerView.ViewHolder {

        TextView mood;
        TextView text;
        TextView date;

        public MoodHolder(@NonNull View itemView) {
            super(itemView);

            mood = itemView.findViewById(R.id.text_view_mood);
            text = itemView.findViewById(R.id.text_view_text);
            date = itemView.findViewById(R.id.text_view_date_mood);

        }
    }
}
