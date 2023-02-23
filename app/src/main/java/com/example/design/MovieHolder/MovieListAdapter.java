package com.example.design.MovieHolder;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.design.MovieData.Movie;

public class MovieListAdapter extends ListAdapter<Movie, MovieViewHolder> {

    public MovieListAdapter (@NonNull DiffUtil.ItemCallback<Movie> diffCallBackMovie) {
        super(diffCallBackMovie);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MovieViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie currentMovie = getItem(position);
        holder.bind(currentMovie.getMovieName());
        holder.bind1(currentMovie.getMovieRate());
    }

    public static class MovieDiff extends DiffUtil.ItemCallback<Movie> {

        @Override
        public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem==newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.getMovieName().equals(newItem.getMovieName());
        }
    }
}