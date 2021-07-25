package com.example.akirachixregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var Register=findViewById<Button>(R.id.btnRegister)
        var Login=findViewById<Button>(R.id.btnLogin)
        Register.setOnClickListener{
            var intent=Intent(baseContext,LoginRegistration::class.java)
            startActivity(intent)
           diplayCourses()


        }
        Register.setOnClickListener{
            var intent=Intent(baseContext,AdminPage::class.java)
            startActivity(intent)

            fun displayCourses(){
                var rvCourses = findViewById<RecyclerView>(R.id.rv)
                var coursesList = listOf(
                    courses( "MB101", "Mobile Development","Introduction to Android development", "John Ouwor"),
                    courses("ui34","UI/UX Design","Designing","Eric"),
                    courses("ux45","UX/Reseach","Research","Joy"),

                    )
                var coursesAdapter=coursesAdapter(coursesList)
                rvCourses.layoutManager= LinearLayoutManager(baseContext)
                rvCourses.adapter=coursesAdapter





            }

        }



    }
}
