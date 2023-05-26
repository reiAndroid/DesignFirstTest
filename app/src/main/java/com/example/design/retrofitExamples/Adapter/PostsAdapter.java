package com.example.design.retrofitExamples.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.design.R;
import com.example.design.retrofitExamples.ui.posts.Posts;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<Posts> posts;

    public void setPosts(List<Posts> setListPosts) {
        this.posts = setListPosts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.albums_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Posts post = posts.get(position);

        holder.setUserId(post.getuserId());
        holder.setAlbumId(post.getid());
        holder.setTitleText(post.getTitle());
        holder.setBodyText(post.getBody());

       /* holder.user_id.setText(String.valueOf(posts.get(position).getuserId()));
        * holder.album_id.setText(String.valueOf(posts.get(position).getid()));
        holder.title_text.setText(posts.get(position).getTitle());
        holder.body_text.setText(posts.get(position).getBody());*/

        holder.itemView.setOnClickListener(v -> {
            //TODO: Go to another fragment
        });
    }

    @Override
    public int getItemCount() {

        //Check list
        if (posts == null) {
            return 0;
        } else {
            return posts.size();
        }
    }

    //ViewHolder for RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView user_id;
        private final TextView album_id;
        private final TextView title_text;
        private final TextView body_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            user_id = itemView.findViewById(R.id.user_id);
            album_id = itemView.findViewById(R.id.album_id);
            title_text = itemView.findViewById(R.id.title_text);
            body_text = itemView.findViewById(R.id.body_text);
        }

        private void setUserId(int userId) {
            user_id.setText(String.valueOf(userId));
        }

        private void setAlbumId(int albumId) {
            album_id.setText(String.valueOf(albumId));
        }

        private void setTitleText(String title) {
            title_text.setText(title);
        }

        private void setBodyText(String bodyText) {
            body_text.setText(bodyText);
        }

    }
}