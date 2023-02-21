package com.example.design.MovieData;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "movie_table")
public class MovieModel {

    @PrimaryKey
    @NonNull

    @ColumnInfo(name = "movie_name")
    private String movie_name;

    @ColumnInfo(name = "movie_rate")
    private int movie_rate;

    public MovieModel (@NonNull String movie_name, int movie_rate) {
        this.movie_name = movie_name;
        this.movie_rate = movie_rate;
    }


    public void setMovie_name(@NonNull String movie_name){
        this.movie_name=movie_name;
    }

    public void setMovie_rate(int movie_rate) {
        this.movie_rate=movie_rate;
    }


    @NonNull
    public String getMovie_name() {
        return this.movie_name;
    }

    public int getMovie_rate() {
        return this.movie_rate;
    }
}