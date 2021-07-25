package com.example.akirachixregistration

import android.content.Intent
import android.os.Bundle
import android.telecom.Call
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.akirachixregistration.api.ApiClient
import com.example.akirachixregistration.api.ApiInterface
import com.example.akirachixregistration.models.loginRequest
import com.example.akirachixregistration.models.loginResponse
import javax.security.auth.callback.Callback

class LoginActivity : AppCompatActivity() {
    lateinit var etemail:TextView
    lateinit var etpassword:TextView
    lateinit var btnlogin:Button
    override fun onCreate(savedInstanceState:Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setViews()
    }
    fun  setViews(){
        etemail=findViewById(R.id.etemail)
        etpassword=findViewById(R.id.etPassword)
        btnlogin=findViewById(R.id.btnlogin)
    }
    fun clickLogin(){
        var error = false
        btnlogin.setOnClickListener{
            var email=etemail.text.toString()
            if(email.isEmpty())
                etemail.setError("Email is required")
        }
        var password=etpassword.text.toString()
        if(password.isEmpty()){
            etpassword.setError("password is required")
        }
        var loginRequest=loginRequest(
            Email= "email",
            Password="password",
        )
        btnlogin.setOnClickListener {
            var intent=Intent(baseContext,coursesPage::class.java)
            startActivity(intent)
        }
        var retrofit = ApiClient.builderApiClient(ApiInterface::class.java)
        var request = retrofit.loginStudent(loginRequest)
        request.enqueue(object : Callback<loginResponse> {
            override fun onResponse(call: Call<loginResponse>, response: Response<loginResponse>) {
                if (response.isSuccessful)
                    Toast.makeText(baseContext, "Login Successful", Toast.LENGTH_LONG)
                        .show()
            }
            override fun onFailure(call: Call<loginResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
