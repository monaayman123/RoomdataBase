package com.example.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update

@Entity(tableName = "student_TABLE")
 data class Student (
@PrimaryKey(autoGenerate = true)

     val  id:Int =0,
  @ColumnInfo(name="student_name")
     val name:String,
     val age:Int,
     val college:String
 )

