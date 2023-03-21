package com.example.design.students;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.design.Courses.Courses;

//Entity class
@Entity(tableName = "students")
public class Students {

    //Attributes
    @PrimaryKey(autoGenerate = true)
    public int studentId;
    public String studentName, studentSurname;
    public int studentAge;
    public double studentAverage;
    public boolean excellent = false;
    public boolean working = false;

    public int course_id = -1;

    //Object constructor
    public Students (int studentId, String studentName, String studentSurname, int studentAge, double studentAverage, boolean excellent, boolean working, int course_id) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.studentAge = studentAge;
        this.studentAverage = studentAverage;
        this.excellent = excellent;
        this.working = working;
        this.course_id = course_id;
    }

    //Null constructor
    public Students () {}


    //Getter and Setter methods
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public double getStudentAverage() {
        return studentAverage;
    }

    public void setStudentAverage(double studentAverage) {
        this.studentAverage = studentAverage;
    }

    public boolean isExcellent() {
        return excellent;
    }

    public void setExcellent(boolean excellent) {
        this.excellent = excellent;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    //Getter and Setter for Course ID
    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int courseId) {
        this.course_id = courseId;
    }
}