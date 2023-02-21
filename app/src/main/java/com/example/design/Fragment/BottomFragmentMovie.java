package com.example.design.Fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.design.MovieData.MovieDao;
import com.example.design.MovieData.MovieDatabase;
import com.example.design.MovieData.MovieModel;
import com.example.design.R;
import com.example.design.databinding.MovieTitleDatabseBinding;

public class BottomFragmentMovie extends Fragment {


    private EditText editText_setMovie, editText_setRate;
    private Button cancel_button, set_button;

    private MovieDao movieDao;
    private MovieModel movieModel;

    private MovieDatabase movieDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_bottom_movie, container, false);

        set_button = view.findViewById(R.id.save_movie_button);
        cancel_button = view.findViewById(R.id.cancel_saving_movies);
        editText_setMovie = view.findViewById(R.id.new_movie_edit);
        editText_setRate = view.findViewById(R.id.rate_edit);

        set_button.setOnClickListener(view1 -> {
            insertMovie();
            Navigation.findNavController(view).navigate(R.id.movieHost);
        });

        cancel_button.setOnClickListener(view1 -> Navigation.findNavController(view).navigate(R.id.movieHost));

        return view;
    }

    private void insertMovie() {

        movieDao = movieDatabase.movieDao();
        movieDao.deleteAll();

        String movie_name = editText_setMovie.getText().toString();
        int movie_rate = 9;

        movieModel.setMovie_name(movie_name);
        movieModel.setMovie_rate(movie_rate);
        movieModel = new MovieModel(movie_name, movie_rate);

        MovieDatabase.service.execute(() -> {
            movieDao.insert(movieModel);
        });
    }
}