package com.example.design.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.design.MovieData.Movie;
import com.example.design.MovieData.MovieModelClass;
import com.example.design.R;

public class BottomFragmentMovie extends Fragment {


    private EditText movieName, movieRate;
    private Button cancel_button, set_button;
    private MovieModelClass movieModel;
    private Movie movie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_bottom_movie, container, false);

        set_button = view.findViewById(R.id.save_movie_button);
        cancel_button = view.findViewById(R.id.cancel_saving_movies);
        movieName = view.findViewById(R.id.new_movie_edit);
        movieRate = view.findViewById(R.id.rate_edit);

        movieModel = new ViewModelProvider((ViewModelStoreOwner) requireContext()).get(MovieModelClass.class);
        movie = new Movie();

        set_button.setOnClickListener(view1 -> {
            insertMovie();
            Navigation.findNavController(view).navigate(R.id.movieHost);
        });

        cancel_button.setOnClickListener(view1 -> Navigation.findNavController(view).navigate(R.id.movieHost));

        return view;
    }

    private void insertMovie() {

        String movie_name = movieName.getText().toString();
        int movie_rate = Integer.parseInt(movieRate.getText().toString());

        movie.setMovie_name(movie_name);
        movie.setMovie_rate(movie_rate);

        movieModel.insert(movie);
    }
}