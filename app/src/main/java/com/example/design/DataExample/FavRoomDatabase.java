package com.example.design.DataExample;

import static com.example.design.Activities.ExampleOfDatabase.sRoomDatabaseCallback;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Fav.class}, version = 1, exportSchema = false)
public abstract class FavRoomDatabase extends RoomDatabase {

    public abstract FavDao favDao();

    public static volatile FavRoomDatabase INSTANCE;
    private static final int num_of_threads = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(num_of_threads);

    static FavRoomDatabase getDatabase (final Context context) {
        if (INSTANCE==null) {
            synchronized (FavRoomDatabase.class) {
                if (INSTANCE==null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), FavRoomDatabase.class, "fav_table")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}