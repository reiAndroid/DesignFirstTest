package com.example.design.MovieData;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert (Movie movies);

    @Query("DELETE FROM movie_table")
    void deleteAll();

    @Query("SELECT * FROM movie_table")
    LiveData<List<Movie>> movies();

    @Query("SELECT * FROM movie_table")
    LiveData<List<Movie>> fromHighestRate();
}
