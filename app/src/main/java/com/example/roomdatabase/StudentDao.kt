package com.example.roomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentDao{
    @Query("SELECT*FROM student_TABLE")
    fun getAllStudent():List<Student>
    @Query("SELECT*FROM student_TABLE where student_name=:name")
    fun getStudentWithName(name: String):List<Student>
    @Insert
    fun insertStudent(student:Student)
    @Delete
    fun deleteStudent(student: Student)
    @Update
    fun updatStudent(student: Student)

}

