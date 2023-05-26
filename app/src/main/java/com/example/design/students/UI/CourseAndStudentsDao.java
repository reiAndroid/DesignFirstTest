package com.example.design.students.UI;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.example.design.students.UI.CourseAndStudent;

import java.util.List;

@Dao
public interface CourseAndStudentsDao {

    @Query("SELECT*FROM courses INNER JOIN courses_students ON courses_students.joinCourseId=courseId INNER JOIN students ON studentId=courses_students.joinStudentId WHERE id=:id")
    LiveData<List<CourseAndStudent>> findAll(int id);
}