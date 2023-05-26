package com.example.design.students.UI;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.design.Courses.UI.Courses;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CourseAndStudent.class, Students.class, Courses.class}, version = 3, exportSchema = false)
public abstract class CSDatabase extends RoomDatabase{

    public abstract CourseAndStudentsDao courseAndStudentsDao();
    public static final int threads = 4;
    public static volatile CSDatabase csDatabaseInstance;
    public static final ExecutorService executorService = Executors.newFixedThreadPool(threads);

    public static CSDatabase getCsDatabaseInstance(Context context) {
        if(csDatabaseInstance==null) {
            synchronized (CSDatabase.class) {
                if (csDatabaseInstance==null) {
                    csDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(), CSDatabase.class, "csDatabase")
                            .addCallback(csCallBack)
                            .build();
                }
            }
        }
        return csDatabaseInstance;
    }

    public static RoomDatabase.Callback csCallBack = new Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            executorService.execute(()-> {
                CourseAndStudentsDao csDao = csDatabaseInstance.courseAndStudentsDao();
                CourseAndStudent courseAndStudent = new CourseAndStudent();
                csDao.findAll(courseAndStudent.id);
            });
        }
    };
}