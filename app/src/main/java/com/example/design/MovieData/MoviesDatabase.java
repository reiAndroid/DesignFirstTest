package com.example.design.MovieData;

import static com.example.design.MovieHost.movieRoomDatabaseCallBack;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Movie.class}, version = 1, exportSchema = false)
public abstract class MoviesDatabase extends RoomDatabase {

    public abstract MovieDao movieDao();
    public static volatile MoviesDatabase Instance;
    public static final int number_of_threads_movie = 4;
    public static final ExecutorService service1 = Executors.newFixedThreadPool(number_of_threads_movie);

    static MoviesDatabase getMoviesDatabase(final Context context) {
        if (Instance == null) {
            synchronized (MoviesDatabase.class) {
                if (Instance == null) {
                    Instance = Room.databaseBuilder(context.getApplicationContext(), MoviesDatabase.class, "movie_table")
                            .addCallback(movieRoomDatabaseCallBack)
                            .build();
                }
            }
        }
        return Instance;
    }
}