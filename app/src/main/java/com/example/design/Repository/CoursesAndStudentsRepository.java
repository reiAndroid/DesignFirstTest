package com.example.design.Repository;

import android.app.Application;
import com.example.design.students.CSDatabase;
import com.example.design.students.CourseAndStudent;
import com.example.design.students.CourseAndStudentsDao;
import java.util.List;

public class CoursesAndStudentsRepository {

    private CourseAndStudentsDao cAndS;
    private List<CourseAndStudent> courseAndStudentList;
    private CourseAndStudent cs;

    public CoursesAndStudentsRepository (Application application) {
        CSDatabase csDatabase = CSDatabase.getCsDatabaseInstance(application);
        cAndS = csDatabase.courseAndStudentsDao();
        courseAndStudentList = cAndS.findAll(cs.id);
    }

    public List<CourseAndStudent> getCourseAndStudentList() {
        return courseAndStudentList;
    }

    public void getAllItems(int id) {
        CSDatabase.executorService.execute(()-> cAndS.findAll(id));
    }
}