package com.example.design.ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.design.Repository.StudentRepository;
import com.example.design.students.Students;

import java.util.List;

public class StdViewModel extends AndroidViewModel {

    private final StudentRepository studentRepository;
    private final LiveData<List<Students>> students;
    public StdViewModel(@NonNull Application application) {
        super(application);

        studentRepository = new StudentRepository(application);
        students = studentRepository.getAllStudents();
    }


    public LiveData<List<Students>> getStudents() {
        return students;
    }

    public void addStudent(Students students) {
        studentRepository.insertStd(students);
    }

    public void deleteOneStudent(Students std) {
        studentRepository.deleteStudent(std);
    }

    public void deleteAllStudents() {
        studentRepository.deleteAllStudents();
    }

    public void updateStudent(Students students) {
        studentRepository.updateStudent(students);
    }

    public Students getStudentsById(int studentId) {
        return studentRepository.getStdById(studentId);
    }
}