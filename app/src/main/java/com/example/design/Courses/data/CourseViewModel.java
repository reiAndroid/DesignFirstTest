package com.example.design.Courses.data;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.design.Courses.UI.Courses;

import java.util.List;

public class CourseViewModel extends AndroidViewModel {

    private CourseRepository courseRepository;
    private LiveData<List<Courses>> coursesList;
    public CourseViewModel(@NonNull Application application) {
        super(application);

        courseRepository = new CourseRepository(application);
        coursesList = courseRepository.getCoursesList();
    }

    public LiveData<List<Courses>> getCoursesList() {
        return coursesList;
    }

    public void addCourses(Courses courses) {
        courseRepository.addCoursesList(courses);
    }
}