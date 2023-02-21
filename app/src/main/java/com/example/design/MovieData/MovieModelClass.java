package com.example.design.MovieData;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MovieModelClass extends AndroidViewModel {

    private MovieRepository movieRepository;

    public final LiveData<List<MovieModel>> movie_model_name;

    public final LiveData<List<MovieModel>> movie_model_rate;

    public MovieModelClass(@NonNull Application application) {
        super(application);

        movieRepository = new MovieRepository(application);

        movie_model_name = movieRepository.getExample_movie_name();
        movie_model_rate = movieRepository.getExample_movie_rate();
    }

    public LiveData<List<MovieModel>> getMovie_model_name() {
        return movie_model_name;
    }


    public LiveData<List<MovieModel>> getMovie_model_rate() {
        return movie_model_rate;
    }

    public void insert(MovieModel model) {
        movieRepository.insert(model);
    }
}