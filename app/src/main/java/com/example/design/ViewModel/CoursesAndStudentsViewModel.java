package com.example.design.ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.design.Repository.CoursesAndStudentsRepository;
import com.example.design.students.CourseAndStudent;
import java.util.List;

public class CoursesAndStudentsViewModel extends AndroidViewModel {

    private CoursesAndStudentsRepository cAndSRepository;
    private List<CourseAndStudent> courseAndStudentList;

    public CoursesAndStudentsViewModel(@NonNull Application application) {
        super(application);

        cAndSRepository = new CoursesAndStudentsRepository(application);
        courseAndStudentList = cAndSRepository.getCourseAndStudentList();
    }

    public List<CourseAndStudent> getCourseAndStudentList() {
        return courseAndStudentList;
    }

    public void getAllItems(int id) {
        cAndSRepository.getAllItems(id);
    }
}