package com.example.akirachixregistration.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.akirachixregistration.models.RegisterResponse
import com.example.akirachixregistration.models.RegistrationRequest
import com.example.akirachixregistration.repository.UserRepository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.example.registration.models.RegistrationRequest
//import com.example.registration.models.RegistrationResponse
//import com.example.registration.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    var registrationLiveData = MutableLiveData<RegisterResponse>()
    var regFailedLiveData = MutableLiveData<String>()
    var userRepository = UserRepository()

    fun registerStudent(registrationRequest: RegistrationRequest){
        viewModelScope.launch {
            var response = userRepository.registerStudent(registrationRequest)
            if (response.isSuccessful){
                registrationLiveData.postValue(response.body())
            }
            else{
                regFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}
