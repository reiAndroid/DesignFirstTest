package com.example.design.students;

import androidx.room.Dao;
import androidx.room.Query;
import java.util.List;

@Dao
public interface CourseAndStudentsDao {

    @Query("SELECT*FROM courses INNER JOIN courses_students ON courses_students.joinCourseId=courseId INNER JOIN students ON studentId=courses_students.joinStudentId WHERE id=:id")
    List<CourseAndStudent> findAll(int id);
}