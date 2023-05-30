package com.example.design.retrofitExamples.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.design.R;
import com.example.design.retrofitExamples.ui.comments.Comments;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder>{

    private List<Comments> commentsList;

    public void setCommentsList(List<Comments> setCommentsLists) {
        this.commentsList = setCommentsLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comments_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.posts_id.setText(String.valueOf(commentsList.get(position).getPostId()));
        holder.comments_id.setText(String.valueOf(commentsList.get(position).getId()));
        holder.name_text.setText(commentsList.get(position).getName());
        holder.email_text.setText(commentsList.get(position).getEmail());
        holder.body_comments_text.setText(commentsList.get(position).getBody());

    }

    @Override
    public int getItemCount() {

       if (commentsList != null) {
           return commentsList.size();
       } else {
           return 0;
       }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView posts_id, comments_id, name_text, email_text, body_comments_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            posts_id = itemView.findViewById(R.id.posts_id);
            comments_id = itemView.findViewById(R.id.comments_id);
            name_text = itemView.findViewById(R.id.name_text);
            email_text = itemView.findViewById(R.id.email_text);
            body_comments_text = itemView.findViewById(R.id.body_comments_text);
        }
    }
}
