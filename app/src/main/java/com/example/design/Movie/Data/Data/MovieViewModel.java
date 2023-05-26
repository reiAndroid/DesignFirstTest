package com.example.design.Movie.Data.Data;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.design.Movie.Data.UI.Movie;
import com.example.design.Movie.Data.Data.MoviesRepository;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {

    private MoviesRepository moviesRepository;
    private LiveData<List<Movie>> allMovies = new MutableLiveData();
    public LiveData<List<Movie>> searchResults = new MutableLiveData(allMovies);

    public MovieViewModel (Application application) {
        super(application);

        moviesRepository = new MoviesRepository(application);
        allMovies = moviesRepository.getAllMovies();
    }

    public LiveData<List<Movie>> getAllMovies() {
        return allMovies;
    }

    public void insert(Movie movie) {
        moviesRepository.insertMovie(movie);
    }

    public void updateMovies(Movie movie) {
        moviesRepository.update(movie);
    }

    public void update(String movieName, int movieRate, int id) {
        moviesRepository.updateMovie(movieName, movieRate, id);
    }

    public void delete(Movie movie) {
        moviesRepository.deleteMovie(movie);
    }

    public void deleteAll() {
        moviesRepository.deleteAll();
    }

    public void searchMovies(String searchMovies) {

    }
}