package com.example.design.Courses.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.design.Courses.UI.CourseDatabase;
import com.example.design.Courses.UI.Courses;
import com.example.design.Courses.UI.CoursesDao;

import java.util.List;

public class CourseRepository {
    private CoursesDao coursesDao;
    private LiveData<List<Courses>> coursesList;

    public CourseRepository(Application application) {
        CourseDatabase courseDatabase = CourseDatabase.courseDatabase(application);
        coursesDao = courseDatabase.coursesDao();
        coursesList = coursesDao.readAllCourses();
    }

    public LiveData<List<Courses>> getCoursesList() {
        return coursesList;
    }

    public void addCoursesList(Courses courses) {
        CourseDatabase.courseService.execute(() -> coursesDao.addCoursesInDb(courses));
    }
}
