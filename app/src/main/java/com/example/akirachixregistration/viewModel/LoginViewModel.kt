package com.example.akirachixregistration.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.akirachixregistration.models.loginRequest
import com.example.akirachixregistration.models.loginResponse
import com.example.akirachixregistration.repository.UserRepository
//import com.example.registration.models.LogInRequest
//import com.example.registration.models.LogInResponse
//import com.example.registration.repository.UserRepository
import kotlinx.coroutines.launch

class LogInViewModel:ViewModel() {
    var logInLiveData = MutableLiveData<loginResponse>()
    var logInFailedLiveData = MutableLiveData<String>()
    var userRepository = UserRepository()

    fun logIn(loginRequest: loginRequest){
        viewModelScope.launch {
            var response = userRepository.login(loginRequest)
            if (response.isSuccessful){
                logInLiveData.postValue(response.body())
            }
            else{
                logInFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}