package com.example.design.ViewModel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.design.MovieData.Movie;
import com.example.design.Repository.MoviesRepository;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {

    private MoviesRepository moviesRepository;
    private final LiveData<List<Movie>> allMovies;

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

    public void update(String movieName, int movieRate, int id) {
        moviesRepository.updateMovie(movieName, movieRate, id);
    }

    public void delete(Movie movie) {
        moviesRepository.deleteMovie(movie);
    }
}