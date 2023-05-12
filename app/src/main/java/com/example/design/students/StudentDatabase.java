package com.example.design.students;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Students.class}, version = 1, exportSchema = false)
public abstract class StudentDatabase extends RoomDatabase {

    public abstract StudentDao studentDao();
    public static final int numOfThreads = 4;
    public static volatile StudentDatabase STUDENT_INSTANCE;
    public static final ExecutorService studentService = Executors.newFixedThreadPool(numOfThreads);

    public static StudentDatabase getStudentInstance(final Context context) {
        if (STUDENT_INSTANCE==null) {
            synchronized (StudentDatabase.class) {
                if(STUDENT_INSTANCE==null) {
                    STUDENT_INSTANCE = Room.databaseBuilder(context.getApplicationContext(), StudentDatabase.class, "students")
                            .addCallback(studentsRoomCallBack)
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return STUDENT_INSTANCE;
    }

    public static RoomDatabase.Callback studentsRoomCallBack = new RoomDatabase.Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            studentService.execute(() -> {
                StudentDao studentDao = STUDENT_INSTANCE.studentDao();

                Students students = new Students(1, "Rei", "Kraja", 21, 9.6, true, true, "English");
                studentDao.addStudent(students);
            });
        }
    };
}