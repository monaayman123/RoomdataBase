package com.example.roomdatabase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.Database
import androidx.room.Room
import com.example.roomdatabase.ui.theme.RoomdataBaseTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomdataBaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val context= LocalContext.current

                    val database= Room.databaseBuilder(
                        context=context,
                        klass = StudentDatabase::class.java,
                        "student_database"
                    ).allowMainThreadQueries().build()

                    val studentDao=database.studentDao()

                    var name by remember { mutableStateOf("") }
                    var age by remember { mutableStateOf(0) }
                    var college by remember { mutableStateOf("") }
                    var data by remember { mutableStateOf("") }
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        TextField(value =name , onValueChange = {name=it})
                        Spacer(modifier = Modifier.height(12.dp))
                        TextField(value =age.toString(), onValueChange = {age=it.toInt()})
                        Spacer(modifier = Modifier.height(12.dp))
                        TextField(value =college , onValueChange = {college=it})
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(onClick = {
                            val student=Student(name=name,age=age,college=college)
                            studentDao.insertStudent(student)
                        }) {
                            Text(text = "insert")
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(onClick = {
                            val student=Student(name=name,age=age,college=college)
                            studentDao.deleteStudent(student  )
                        }) {
                            Text(text = "delete")
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(onClick = {
                            val list=   studentDao.getAllStudent()
                            list[0].copy(age=8)
                            data=studentDao.getAllStudent().joinToString ("\n" )

                        }) {
                            Text(text = "Retrieve")
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(onClick = {

                        }) {
                            Text(text = "update")
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(text = data)

                    }





                }
            }
        }
    }
}




