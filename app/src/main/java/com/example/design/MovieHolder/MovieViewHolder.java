package com.example.design.MovieHolder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private TextView movie_dB_name, movie_dB_rate;
    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);

        movie_dB_name = itemView.findViewById(R.id.movie_dB_name);
        movie_dB_rate = itemView.findViewById(R.id.movie_dB_rate);
    }

    public void setMovie_dB_name(String text_name) {
        movie_dB_name.setText(text_name);
    }

    public void setMovie_dB_rate(int movie_dB_rate1) {
        movie_dB_rate.setText(String.valueOf(movie_dB_rate1));
    }

    static MovieViewHolder create (ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_title_databse, viewGroup,false);
        return new MovieViewHolder(view);
    }
}