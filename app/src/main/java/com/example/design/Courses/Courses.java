package com.example.design.Courses;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

@Entity (tableName = "courses")
public class Courses {

    //Attributes
    @PrimaryKey(autoGenerate = true)
    public int courseId;
    public String courseName;

    //Object constructor
    public Courses (int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public Courses(String courseName) {
        this.courseName = courseName;
    }

    //Null constructor
    public Courses() {}

    //Getter and Setter methods
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}