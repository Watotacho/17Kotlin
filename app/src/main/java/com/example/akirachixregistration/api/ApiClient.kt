package com.example.akirachixregistration.api
import  retrofit2.Retrofit
import  retrofit2.converter.gson.GsonConverterFactory
object ApiClient {
    var retrofit=Retrofit.Builder(
    .baseUrl("http://13.244.243.129" )
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    fun<T> builderApiClient(apiInterface: Class<T>): T {
        return retrofit.create(apiInterface)
    }
}


