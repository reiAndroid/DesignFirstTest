package com.example.design.students;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.example.design.Courses.Courses;

@Entity(tableName = "courses_students",
        indices = {@Index(value = {"joinStudentId", "joinCourseId"})},
        foreignKeys = {
        @ForeignKey(entity = Students.class, parentColumns = "studentId", childColumns = "joinStudentId"),
        @ForeignKey(entity = Courses.class, parentColumns = "courseId", childColumns = "joinCourseId")
})
public class CourseAndStudent {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "joinStudentId")
    public int joinStudentId;

    @ColumnInfo(name = "joinCourseId")
    public int joinCourseId;
}