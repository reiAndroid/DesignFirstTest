package com.example.design.MovieHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.example.design.R;

import com.example.design.MovieData.Movie;

public class MovieListAdapter extends ListAdapter<Movie, MovieViewHolder> {
    public MovieListAdapter(@NonNull DiffUtil.ItemCallback<Movie> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MovieViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie model = getItem(position);

        holder.setMovie_dB_name(model.getMovie_name());
        holder.setMovie_dB_rate(model.getMovie_rate());

        holder.itemView.findViewById(R.id.movie_dB_name).setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.bottomFragmentMovie);
        });
    }

    public static class MovieDiff extends DiffUtil.ItemCallback<Movie> {

        @Override
        public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem==newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.getMovie_name().equals(newItem.getMovie_name());
        }
    }
}