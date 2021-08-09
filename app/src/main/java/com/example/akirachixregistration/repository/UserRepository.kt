package com.example.akirachixregistration.repository



import com.example.AkirachixRegistration.api.ApiClient
import com.example.akirachixregistration.models.RegisterResponse
import com.example.akirachixregistration.models.RegistrationRequest
import com.example.akirachixregistration.models.loginRequest
import com.example.akirachixregistration.models.loginResponse
import com.example.registration.api.ApiClient
import com.example.registration.api.ApiInterface

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun registerStudent(registrationRequest: RegistrationRequest):
            Response<RegisterResponse> = withContext(Dispatchers.IO){
        var response = apiInterface.registerStudent(registrationRequest)
        return@withContext response
    }

    suspend fun login(logInRequest: loginRequest):Response<loginResponse> =
        withContext(Dispatchers.IO){
            var response = apiInterface.logInStudent(logInRequest)
            return@withContext response
        }
}
