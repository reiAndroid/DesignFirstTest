package com.example.design.Movie.Data.UI;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "movies")
public class Movie {

    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "movieId")
    public int id;

    @ColumnInfo(name = "movieName")
    public String movieName;

    @ColumnInfo(name = "movieRate")
    public int movieRate;

    public Movie (int id, String movieName, int movieRate) {
        this.id = id;
        this.movieName = movieName;
        this.movieRate = movieRate;
    }

    public Movie(String movieName, int movieRate) {
        this.movieName = movieName;
        this.movieRate = movieRate;
    }
    public Movie() {}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieRate(int movieRate) {
        this.movieRate = movieRate;
    }

    public int getMovieRate() {
        return movieRate;
    }
}