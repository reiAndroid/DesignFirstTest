package com.example.design.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.design.MovieData.Movie;
import com.example.design.MovieData.MovieDB;
import com.example.design.MovieData.MoviesDao;

import java.util.List;

public class MoviesRepository {
    private MoviesDao moviesDao;
    private LiveData<List<Movie>> allMovies;

    public MoviesRepository(Application app) {
        MovieDB db = MovieDB.getDatabase(app);
        moviesDao = db.moviesDao();
        allMovies = moviesDao.moviesData();
    }

    public LiveData<List<Movie>> getAllMovies() {
        return allMovies;
    }

    public void insertMovie(Movie movie) {
        MovieDB.service.execute(() -> moviesDao.insertMovie(movie));
    }

    //new
    public void update(Movie movie) {
        MovieDB.service.execute(() -> moviesDao.update(movie));
    }

    public void updateMovie(String movieName, int movieRate, int id) {
        MovieDB.service.execute(() -> moviesDao.updateMovie(movieName, movieRate, id));
    }

    public void deleteMovie(Movie movie) {
        MovieDB.service.execute(() -> moviesDao.deleteMovie(movie));
    }

    //new
    public void deleteAll() {
        MovieDB.service.execute(() -> moviesDao.deleteAll());
    }
}