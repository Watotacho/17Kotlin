package com.example.registration.api

import com.example.akirachixregistration.models.RegistrationRequest
import com.example.akirachixregistration.models.loginRequest
import com.example.akirachixregistration.models.loginResponse
//import com.example.registration.models.loginRequest
//import com.example.registration.models.loginResponse
//import com.example.registration.models.RegistrationRequest
//import com.example.registration.models.RegistrationResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
    suspend fun registerStudent(@Body registrationRequest: RegistrationRequest): Response<RegistrationRequest>

    @POST("/students/login")
    suspend fun logInStudent(@Body logInRequest: loginRequest): Response<loginResponse>
}