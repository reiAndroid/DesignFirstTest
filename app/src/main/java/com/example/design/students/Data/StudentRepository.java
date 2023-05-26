package com.example.design.students.Data;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.design.students.UI.StudentDao;
import com.example.design.students.UI.StudentDatabase;
import com.example.design.students.UI.Students;

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