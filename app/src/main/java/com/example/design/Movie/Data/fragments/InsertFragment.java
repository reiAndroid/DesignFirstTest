package com.example.design.Movie.Data.fragments;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.design.Movie.Data.UI.Movie;
import com.example.design.R;
import com.example.design.Movie.Data.Data.MovieViewModel;

public class InsertFragment extends Fragment {

    private ConstraintLayout insertMovie;
    private LinearLayout actionsMoviesLayout, buttonsLayout;
    private TextView textMoreMovies, textExplainMovies, textRateMovies;
    private EditText userMovieName, userRateName;
    private Button cancelMovieButton, setMovieButton;
    private MovieViewModel viewModel;
    private Movie movie;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_insert, container, false);

        //Layout initialization
        insertMovie = view.findViewById(R.id.insertMovieLayout);
        actionsMoviesLayout = view.findViewById(R.id.actionsMoviesLayout);
        buttonsLayout = view.findViewById(R.id.buttonsLayout);

        //Initialization of Elements
        textMoreMovies = view.findViewById(R.id.textMoreMovies);
        textExplainMovies = view.findViewById(R.id.textExplainMovies);
        textRateMovies = view.findViewById(R.id.textRateMovies);

        //Initialization of User Elements
        userMovieName = view.findViewById(R.id.userMovieName);
        userRateName = view.findViewById(R.id.userRateName);

        //Buttons
        cancelMovieButton = view.findViewById(R.id.cancelMovieButton);
        setMovieButton = view.findViewById(R.id.setMovieButton);

        //onClick events (cancel)
        cancelMovieButton.setOnClickListener(view1 -> {
            Toast.makeText(getContext(), "Nothing to Save", Toast.LENGTH_SHORT).show();
            Navigation.findNavController(view).navigate(R.id.movieDataExample);
        });

        //onClick event (set)
        setMovieButton.setOnClickListener(view1->{
            if(TextUtils.isEmpty(userMovieName.getText()) || TextUtils.isEmpty(userRateName.getText())) {
                Toast.makeText(getContext(), "Nothing to save!", Toast.LENGTH_SHORT).show();
                Navigation.findNavController(view).navigate(R.id.movieDataExample);
            } else {
                insertMovies();
                Navigation.findNavController(view).navigate(R.id.movieDataExample);
            }
        });
        return view;
    }

    public void insertMovies() {

        String movieName = userMovieName.getText().toString();
        int movieRate = Integer.parseInt(userRateName.getText().toString());

        viewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        movie = new Movie(movieName, movieRate);
        viewModel.insert(movie);
    }
}