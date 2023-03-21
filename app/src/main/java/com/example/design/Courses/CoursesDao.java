package com.example.design.Courses;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CoursesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addCoursesInDb(Courses...courses);

    @Query("SELECT*FROM courses")
    List<Courses> readAllCourses();
}
