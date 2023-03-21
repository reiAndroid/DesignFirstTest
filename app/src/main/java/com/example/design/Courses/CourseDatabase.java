package com.example.design.Courses;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Courses.class}, version = 2, exportSchema = false)
public abstract class CourseDatabase extends RoomDatabase {

    public abstract CoursesDao coursesDao();
    public static final int numberOfThread=4;
    public static volatile CourseDatabase COURSE_INSTANCE;
    public static final ExecutorService courseService = Executors.newFixedThreadPool(numberOfThread);

    public static CourseDatabase courseDatabase(final Context coursesContext) {
        if(COURSE_INSTANCE==null) {
            synchronized (CourseDatabase.class) {
                if(COURSE_INSTANCE==null) {
                    COURSE_INSTANCE = Room.databaseBuilder(coursesContext.getApplicationContext(), CourseDatabase.class, "coursesDatabase")
                            .addCallback(courseCallback)
                            .build();
                }
            }
        }
        return COURSE_INSTANCE;
    }

    public static RoomDatabase.Callback courseCallback = new Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            courseService.execute(()-> {
                CoursesDao coursesDao = COURSE_INSTANCE.coursesDao();
            });
        }
    };
}