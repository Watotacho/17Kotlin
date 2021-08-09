package com.example.akirachixregistration.models
import android.accounts.AuthenticatorDescription
import com.google.gson.annotations.SerializedName
data class courseResponse(
    @SerializedName("course_code")var courseCode:String,
    @SerializedName("course_name")var courseName:String,
    var description: String,
    var instructor:String,
)
