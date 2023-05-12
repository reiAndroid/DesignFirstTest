package com.example.design.Repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.design.students.StudentDao;
import com.example.design.students.StudentDatabase;
import com.example.design.students.Students;

import java.util.List;

public class StudentRepository {
    private StudentDao studentDao;
    private LiveData<List<Students>> allStudents;

    public StudentRepository(Application app) {
        StudentDatabase studentDatabase = StudentDatabase.getStudentInstance(app);
        studentDao = studentDatabase.studentDao();
        allStudents = studentDao.getStudents();
    }

    public void insertStd(Students students) {
        StudentDatabase.studentService.execute(() -> studentDao.addStudent(students));
    }

    public void deleteStudent(Students students) {
        StudentDatabase.studentService.execute(() -> studentDao.deleteOne(students));
    }

    public void deleteAllStudents() {
        StudentDatabase.studentService.execute(() -> studentDao.deleteAll());
    }

    public void updateStudent(Students students) {
        StudentDatabase.studentService.execute(() -> studentDao.updateStudent(students));
    }

    public LiveData<List<Students>> getAllStudents() {
        return allStudents;
    }

    public Students getStdById(int studentId) {
       return studentDao.getStudentsById(studentId);
    }
}