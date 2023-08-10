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
    fun getStudentWithName(name: String):String
    @Insert
    fun insertStudent(student:Student)
    @Query("delete from student_TABLE where student_name=student_name")
    fun deleteStudent(name: String)
    @Update
    fun updatStudent(student: Student)

}

