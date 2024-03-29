package com.example.design.students.UI;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.design.students.UI.Students;

import java.util.List;

@Dao
public interface StudentDao {

    //Add student
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addStudent(Students...students);

    //Delete one Student
    @Query("DELETE FROM students WHERE studentId= :studentId")
    void deleteOneStudent(int studentId);

    //Delete all students
    @Query("DELETE FROM students")
    void deleteAll();

    @Delete
    void deleteOne(Students students);

    //Update one item
    @Update
    void updateStudent(Students...students);

    //Get Students
    @Query("SELECT * FROM students")
    LiveData<List<Students>> getStudents();

    @Query("SELECT * FROM students WHERE studentId=:studentsId")
    Students getStudentsById(int studentsId);
}