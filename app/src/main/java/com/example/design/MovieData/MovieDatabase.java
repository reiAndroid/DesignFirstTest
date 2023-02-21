package com.example.design.MovieData;

import static com.example.design.MovieHost.movieRoomDatabaseCallBack;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Movie.class}, version = 1, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {

    public abstract MovieDao movieDao();
    public static volatile MovieDatabase INSTANCE;
    public static final int number_of_threads_movie = 4;
    public static final ExecutorService service = Executors.newFixedThreadPool(number_of_threads_movie);

    static MovieDatabase getMovieDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MovieDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MovieDatabase.class, "movie_table")
                            .addCallback(movieRoomDatabaseCallBack)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}