package com.example.design.retrofitExamples.management;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.design.retrofitExamples.ui.comments.Comments;
import com.example.design.retrofitExamples.ui.posts.PostDao;
import com.example.design.retrofitExamples.ui.posts.Posts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Comments.class, Posts.class}, version = 1, exportSchema = false)
public abstract class RetrofitDatabaseTest extends RoomDatabase {

    public abstract PostDao retrofitDao();
    public static volatile RetrofitDatabaseTest retrofitDatabaseTest;
    public static final int numberOfThreads = 4;
    public static final ExecutorService retrofitExecutor = Executors.newFixedThreadPool(numberOfThreads);

    public static RetrofitDatabaseTest getRetrofitDatabaseTest(final Context context) {
        if (retrofitDatabaseTest == null) {
            synchronized (RetrofitDatabaseTest.class) {
                if (retrofitDatabaseTest == null) {
                    retrofitDatabaseTest = Room.databaseBuilder(context.getApplicationContext(), RetrofitDatabaseTest.class, "retrofit")
                            .addCallback(retrofitCallBack)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return retrofitDatabaseTest;
    }


    public static RoomDatabase.Callback retrofitCallBack = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

        }
    };

}