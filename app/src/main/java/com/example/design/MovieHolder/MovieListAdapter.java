package com.example.design.MovieHolder;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.design.MovieData.MovieModel;

public class MovieListAdapter extends ListAdapter<MovieModel, MovieViewHolder> {
    public MovieListAdapter(@NonNull DiffUtil.ItemCallback<MovieModel> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MovieViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieModel model = getItem(position);
        holder.setMovie_dB_name(model.getMovie_name());
        holder.setMovie_dB_rate(model.getMovie_rate());
    }

    public static class MovieDiff extends DiffUtil.ItemCallback<MovieModel> {

        @Override
        public boolean areItemsTheSame(@NonNull MovieModel oldItem, @NonNull MovieModel newItem) {
            return oldItem==newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull MovieModel oldItem, @NonNull MovieModel newItem) {
            return oldItem.getMovie_name().equals(newItem.getMovie_name());
        }
    }
}