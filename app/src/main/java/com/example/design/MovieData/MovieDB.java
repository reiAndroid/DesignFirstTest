package com.example.design.MovieData;

import static com.example.design.Fragment.MovieDataExample.roomCallBack;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Movie.class}, version = 1, exportSchema = false)
public abstract class MovieDB extends RoomDatabase {

    public abstract MoviesDao moviesDao();
    public static final int numberOfThreads = 4;
    public static volatile MovieDB INSTANCE;

    public static final ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);

    public static MovieDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MovieDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), MovieDB.class, "movie")
                            .addCallback(roomCallBack)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}