package com.example.design.MovieData;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MoviesDao {

    @Insert
    void insertMovie(Movie...movies);

    @Query("UPDATE movies SET movieName=:moviesNames, movieRate=:moviesRates WHERE movieId=:id")
    void updateMovie(String moviesNames, int moviesRates, int id);

    @Delete
    void deleteMovie(Movie movie);

    @Query("SELECT*FROM movies")
    LiveData<List<Movie>> moviesData();
}