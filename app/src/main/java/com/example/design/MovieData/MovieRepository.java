package com.example.design.MovieData;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MovieRepository {

    private MovieDao example_movie_dao;
    private LiveData<List<Movie>> example_movie_name;
    private LiveData<List<Movie>> example_movie_rate;

    MovieRepository (Application app) {
        MovieDatabase mDb = MovieDatabase.getMovieDatabase(app);
        example_movie_dao = mDb.movieDao();
        example_movie_name = example_movie_dao.movies();
        example_movie_rate = example_movie_dao.fromHighestRate();
    }

    LiveData<List<Movie>> getExample_movie_name() {
        return example_movie_name;
    }

    LiveData<List<Movie>> getExample_movie_rate() {
        return example_movie_rate;
    }

    public void insert(Movie model) {
        MovieDatabase.service.execute(() -> {
            example_movie_dao.insert(model);
        });
    }
}