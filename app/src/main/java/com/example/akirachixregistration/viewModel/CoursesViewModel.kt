package com.example.akirachixregistration.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.akirachixregistration.models.courseResponse
import com.example.akirachixregistration.repository.UserRepository

class CoursesViewModel:ViewModel() {
    var courseLiveData=MutableLiveData<courseResponse>()
    var loginFailedLiveData=MutableLiveData<String>()
    var userRepository=UserRepository()

    fun Courses(courseResponse: courseResponse,viewModelScope: Any){
        viewModelScope.launch{
            var response=userRepository.login(courseResponse)
            if(response.isSuccessful){
                courseLiveData.postValue(courseResponse.body())

            }
            else{
                loginFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }

}