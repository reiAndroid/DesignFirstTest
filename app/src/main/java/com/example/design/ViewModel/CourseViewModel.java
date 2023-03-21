package com.example.design.ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.design.Courses.Courses;
import com.example.design.Repository.CourseRepository;
import java.util.List;

public class CourseViewModel extends AndroidViewModel {

    private CourseRepository courseRepository;
    private List<Courses> coursesList;
    public CourseViewModel(@NonNull Application application) {
        super(application);

        courseRepository = new CourseRepository(application);
        coursesList = courseRepository.getCoursesList();
    }

    public List<Courses> getCoursesList() {
        return coursesList;
    }

    public void addCourses(Courses courses) {
        courseRepository.addCoursesList(courses);
    }
}