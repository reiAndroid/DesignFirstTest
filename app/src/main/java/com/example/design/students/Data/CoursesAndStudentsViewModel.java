package com.example.design.students.Data;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.design.students.Data.CoursesAndStudentsRepository;
import com.example.design.students.UI.CourseAndStudent;
import java.util.List;

public class CoursesAndStudentsViewModel extends AndroidViewModel {

    private CoursesAndStudentsRepository cAndSRepository;
    private LiveData<List<CourseAndStudent>> courseAndStudentList;

    public CoursesAndStudentsViewModel(@NonNull Application application) {
        super(application);

        cAndSRepository = new CoursesAndStudentsRepository(application);
        courseAndStudentList = cAndSRepository.getCourseAndStudentList();
    }

    public LiveData<List<CourseAndStudent>> getCourseAndStudentList() {
        return courseAndStudentList;
    }

    public void getAllItems(int id) {
        cAndSRepository.getAllItems(id);
    }
}