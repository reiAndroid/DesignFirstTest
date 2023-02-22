package com.example.design.MovieData;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MovieModelClass extends AndroidViewModel {

    private final MovieRepository movieRepository;

    public final LiveData<List<Movie>> movie_model_name;

    public final LiveData<List<Movie>> movie_model_rate;

    public MovieModelClass(@NonNull Application application) {
        super(application);

        movieRepository = new MovieRepository(application);

        movie_model_name = movieRepository.getExample_movie_name();
        movie_model_rate = movieRepository.getExample_movie_rate();
    }

    public LiveData<List<Movie>> getMovie_model_name() {
        return movie_model_name;
    }


    public LiveData<List<Movie>> getMovie_model_rate() {
        return movie_model_rate;
    }

    public void insert(Movie model) {
        movieRepository.insert(model);
    }

    public void updateMovie(String name, int rate, int id) {
        movieRepository.updateMovie(name, rate, id);
    }
}