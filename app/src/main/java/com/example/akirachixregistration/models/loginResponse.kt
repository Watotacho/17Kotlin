package com.example.akirachixregistration.models

import com.google.gson.annotations.SerializedName

data class loginResponse(
    var message: String,
    @SerializedName("access_token")var accessToken: String,
    @SerializedName("student_id")var studentId: String

)

