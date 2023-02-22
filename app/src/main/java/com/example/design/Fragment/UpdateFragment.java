package com.example.design.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.design.MovieData.Movie;
import com.example.design.MovieData.MovieModelClass;
import com.example.design.R;

public class UpdateFragment extends Fragment {

    private EditText updateMovie, updateRate;
    private Button cancelMoviesButton, updateMovieButton;
    private MovieModelClass modelClass;
    private Movie movie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.update_fragment, container, false);

       updateMovie = view.findViewById(R.id.updateMovies);
       updateRate = view.findViewById(R.id.updateRate);
       cancelMoviesButton = view.findViewById(R.id.cancelMoviesButton);
       updateMovieButton = view.findViewById(R.id.updateMovieButton);


       modelClass = new ViewModelProvider(this).get(MovieModelClass.class);
       movie = new Movie();

       return view;
    }

    private void updateMovieByUser() {

    }
}