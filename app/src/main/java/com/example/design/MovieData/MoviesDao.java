package com.example.design.MovieData;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MoviesDao {

    @Insert
    void insertMovie(Movie...movies);

    @Query("UPDATE movies SET movieName=:moviesNames, movieRate=:moviesRates WHERE movieId=:id")
    void updateMovie(String moviesNames, int moviesRates, int id);

    @Update
    void update(Movie movie);
    @Delete
    void deleteMovie(Movie movie);

    @Query("DELETE FROM movies")
    void deleteAll();

    @Query("SELECT*FROM movies")
    LiveData<List<Movie>> moviesData();
}