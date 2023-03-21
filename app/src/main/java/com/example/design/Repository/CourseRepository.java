package com.example.design.Repository;

import android.app.Application;

import com.example.design.Courses.CourseDatabase;
import com.example.design.Courses.Courses;
import com.example.design.Courses.CoursesDao;

import java.util.List;

public class CourseRepository {
    private CoursesDao coursesDao;
    private List<Courses> coursesList;

    public CourseRepository(Application application) {
        CourseDatabase courseDatabase = CourseDatabase.courseDatabase(application);
        coursesDao = courseDatabase.coursesDao();
        coursesList = coursesDao.readAllCourses();
    }

    public List<Courses> getCoursesList() {
        return coursesList;
    }

    public void addCoursesList(Courses courses) {
        CourseDatabase.courseService.execute(() -> coursesDao.addCoursesInDb(courses));
    }
}
