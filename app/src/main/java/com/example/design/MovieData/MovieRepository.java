package com.example.design.MovieData;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MovieRepository {

    private MovieDao example_movie_dao;
    private LiveData<List<Movie>> example_movie_name;
    private LiveData<List<Movie>> example_movie_rate;

    MovieRepository (Application app) {
        MoviesDatabase mDb = MoviesDatabase.getMoviesDatabase(app);
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
        MoviesDatabase.service1.execute(() -> {
            example_movie_dao.insert(model);
        });
    }

    public void updateMovie(String name, int rate, int id) {
        MoviesDatabase.service1.execute(() -> example_movie_dao.updateMovie(name, rate, id));
    }
}