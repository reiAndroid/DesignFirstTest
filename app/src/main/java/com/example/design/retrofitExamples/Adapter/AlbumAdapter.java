package com.example.design.retrofitExamples.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design.R;
import com.example.design.retrofitExamples.ui.Albums;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private List<Albums> albums;

    public void setAlbums(List<Albums> setListAlbums) {
        this.albums = setListAlbums;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.albums_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.user_id.setText(String.valueOf(albums.get(position).getuserId()));
        holder.album_id.setText(String.valueOf(albums.get(position).getid()));
        holder.title_text.setText(albums.get(position).getTitle());
    }

    @Override
    public int getItemCount() {

        //Check list
        if (albums == null) {
            return 0;
        } else {
            return albums.size();
        }
    }

    //ViewHolder for RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView user_id;
        private final TextView album_id;
        private final TextView title_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            user_id = itemView.findViewById(R.id.user_id);
            album_id = itemView.findViewById(R.id.album_id);
            title_text = itemView.findViewById(R.id.title_text);
        }
    }
}