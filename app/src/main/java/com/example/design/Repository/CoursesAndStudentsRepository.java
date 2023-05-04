package com.example.design.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.design.students.CSDatabase;
import com.example.design.students.CourseAndStudent;
import com.example.design.students.CourseAndStudentsDao;
import java.util.List;

public class CoursesAndStudentsRepository {

    private CourseAndStudentsDao cAndS;
    private LiveData<List<CourseAndStudent>> courseAndStudentList;
    private CourseAndStudent cs;

    public CoursesAndStudentsRepository (Application application) {
        CSDatabase csDatabase = CSDatabase.getCsDatabaseInstance(application);
        cs = new CourseAndStudent();
        cAndS = csDatabase.courseAndStudentsDao();
        courseAndStudentList = cAndS.findAll(cs.id);
    }

    public LiveData<List<CourseAndStudent>> getCourseAndStudentList() {
        return courseAndStudentList;
    }

    public void getAllItems(int id) {
        CSDatabase.executorService.execute(()-> cAndS.findAll(id));
    }
}