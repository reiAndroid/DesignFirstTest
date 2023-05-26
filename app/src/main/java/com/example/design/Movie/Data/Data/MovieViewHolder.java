package com.example.design.Movie.Data.Data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design.R;

public class MovieViewHolder extends RecyclerView.ViewHolder{

    private final TextView textMovieName, textMovieRate;

    public MovieViewHolder (@NonNull View itemView) {
        super(itemView);

        textMovieName = itemView.findViewById(R.id.textMovieName);
        textMovieRate = itemView.findViewById(R.id.textMovieRate);

    }

    public void bind(String name) {
        textMovieName.setText(name);
    }

    public void bind1(int rate){
        textMovieRate.setText(String.valueOf(rate));
    }

    static MovieViewHolder create (ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new MovieViewHolder(view);
    }
}