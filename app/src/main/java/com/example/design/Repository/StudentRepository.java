package com.example.design.Repository;

import android.app.Application;
import com.example.design.students.CourseAndStudent;
import com.example.design.Courses.Courses;
import com.example.design.students.StudentDao;
import com.example.design.students.StudentDatabase;
import com.example.design.students.Students;

import java.util.List;

public class StudentRepository {
    private StudentDao studentDao;
    private List<Students> allStudents;

    public StudentRepository(Application app) {
        StudentDatabase studentDatabase = StudentDatabase.getStudentInstance(app);
        studentDao = studentDatabase.studentDao();
        allStudents = studentDao.getStudents();
    }

    public void insertStd(Students students) {
        StudentDatabase.studentService.execute(() -> studentDao.addStudent(students));
    }

    public void deleteStudent(int id) {
        StudentDatabase.studentService.execute(() -> studentDao.deleteOneStudent(id));
    }

    public void deleteAllStudents() {
        StudentDatabase.studentService.execute(() -> studentDao.deleteAll());
    }

    public void updateStudent(Students students) {
        StudentDatabase.studentService.execute(() -> studentDao.updateStudent(students));
    }

    public List<Students> getAllStudents() {
        return allStudents;
    }
}