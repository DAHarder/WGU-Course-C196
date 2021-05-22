package com.example.c196projectdanadams.ui.terms;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c196projectdanadams.R;
import com.example.c196projectdanadams.data.entity.TermEntity;

import java.util.List;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder> {

    private final LayoutInflater mInflater;
    private final Context context;
    private List<TermEntity> mTerms;

    public TermAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }

    class TermViewHolder extends RecyclerView.ViewHolder {
        private final TextView termItemView;

        private TermViewHolder(View itemView){
            super(itemView);
            termItemView = itemView.findViewById(R.id.term_item_text_view);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick (View v) {
                    int position = getAdapterPosition();
                    final TermEntity currentTerm = mTerms.get(position);
                    Intent intent = new Intent(context, TermEditCourseListActivity.class);
                    intent.putExtra("termID", currentTerm.getTermID());
                    intent.putExtra("position", position);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public TermViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.term_list_item, parent, false);
        return new TermViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TermViewHolder holder, int position) {

        if(mTerms != null) {
            final TermEntity currentTerm = mTerms.get(position);
            holder.termItemView.setText((currentTerm.getTermTitle()));

        } else {
            holder.termItemView.setText("no text");
        }
    }

    @Override
    public int getItemCount() {
        if (mTerms != null)
            return mTerms.size();
        else return 0;
    }

    public void setTerms(List<TermEntity> terms) {
        mTerms = terms;
        notifyDataSetChanged();
    }

}
