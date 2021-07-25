package com.example.akirachixregistration.api

import android.telecom.Call
import com.example.akirachixregistration.models.RegisterResponse
import com.example.akirachixregistration.models.RegistrationRequest
import com.example.akirachixregistration.models.loginRequest
import com.example.akirachixregistration.models.loginResponse


interface ApiInterface {
    @POST("/students/REGISTER")
    fun registerStudent(@Body Regirationrequest: RegistrationRequest): Call<RegisterResponse>

    @POST("student/LOGIN")
    fun loginStudent(@Body loginRequest: loginRequest): Call<loginResponse>
}