package com.example.akirachixregistration.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import com.example.akirachixregistration.models.RegistrationRequest
//import com.example.registration.R
import com.example.registration.api.ApiClient
import com.example.registration.api.ApiInterface
import com.example.registration.databinding.ActivityMainBinding
//import com.example.registration.models.RegistrationRequest
//import com.example.registration.models.RegistrationResponse
import com.example.registration.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel: UserViewModel by viewModels()


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onResume() {
        super.onResume()
        binding.btnRegister.setOnClickListener {
            var regRequest = RegistrationRequest(
                name = binding.etName.toString(),
                phoneNumber = binding.etPhoneNumber.text.toString(),
                email = binding.etEmail.toString(),
                dateOfBirth = binding.etDob.text.toString(),
                password = binding.etPassword.text.toString()
            )
            userViewModel.registerStudent(regRequest)
        }
        userViewModel.registrationLiveData.observe(this, { regResponse ->
            if (!regResponse.studentId.isNullOrEmpty()) {
                Toast.makeText(baseContext, "Registration successful", Toast.LENGTH_LONG).show()
            }
        })
        userViewModel.regFailedLiveData.observe(this, { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }

}













//lateinit var binding:ActivityMainBinding
//binding=ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        override fun onResume(){
//            super.onResume()
//            binding.btnRegister.setOnClickListener{
//                var request=
//                    RegistrationRequest(
//                        name=binding.etname.text.toString(),
//                        phoneNumber = binding.etphone.text.toString(),
//                       email=binding.etemail.text.toString(),
//)
//userViewModel.registerUser(regRequest)
//
//        }
//        userViewModel.registrationLiveData.observe(this,{regResponse->

