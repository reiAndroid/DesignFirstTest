package com.example.design.Movie.Data.Data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.design.Movie.Data.UI.Movie;
import com.example.design.Movie.Data.UI.MovieDB;
import com.example.design.Movie.Data.UI.MoviesDao;

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

    public void deleteAll() {
        MovieDB.service.execute(() -> moviesDao.deleteAll());
    }

    public LiveData<List<Movie>> searchMovie(String searchMovie) {
        return moviesDao.searchMovie(searchMovie);
    }
}