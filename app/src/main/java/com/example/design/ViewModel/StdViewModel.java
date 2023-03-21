package com.example.design.ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.design.Repository.StudentRepository;
import com.example.design.students.CourseAndStudent;
import com.example.design.Courses.Courses;
import com.example.design.students.Students;

import java.util.List;

public class StdViewModel extends AndroidViewModel {

    private StudentRepository studentRepository;
    private List<Students> students;

    public StdViewModel(@NonNull Application application) {
        super(application);

        studentRepository = new StudentRepository(application);
        students = studentRepository.getAllStudents();
    }


    public List<Students> getStudents() {
        return students;
    }

    public void addStudent(Students students) {
        studentRepository.insertStd(students);
    }

    public void deleteOneStudent(int studentId) {
        studentRepository.deleteStudent(studentId);
    }

    public void deleteAllStudents() {
        studentRepository.deleteAllStudents();
    }

    public void updateStudent(Students students) {
        studentRepository.updateStudent(students);
    }
}