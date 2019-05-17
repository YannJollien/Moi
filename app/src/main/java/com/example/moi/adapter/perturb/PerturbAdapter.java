package com.example.moi.adapter.perturb;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.moi.R;
import com.example.moi.database.entity.Perturb;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import org.w3c.dom.Text;

public class PerturbAdapter extends FirestoreRecyclerAdapter<Perturb, PerturbAdapter.PerturbHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public PerturbAdapter(@NonNull FirestoreRecyclerOptions<Perturb> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PerturbHolder holder, int position, @NonNull Perturb model) {
        holder.title.setText(model.getTitle());
        holder.text.setText(model.getText());
        holder.date.setText(model.getDate());
    }

    @NonNull
    @Override
    public PerturbHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.perturb_item,
                viewGroup, false);
        return new PerturbHolder(v);
    }

    public void deleteItem(int position) {
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class PerturbHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView text;
        TextView date;

        public PerturbHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.text_view_title);
            text = itemView.findViewById(R.id.text_view_description);
            date = itemView.findViewById(R.id.text_view_date);

        }
    }
}
