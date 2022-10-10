package com.example.mvvmdemo.retrofit

import retrofit2.Call
import com.example.mvvmdemo.model.ServicesSetterGetter
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/")
    fun getServices() : Call<ServicesSetterGetter>
}