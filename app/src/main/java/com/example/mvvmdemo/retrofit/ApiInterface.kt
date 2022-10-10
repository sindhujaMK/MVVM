package com.example.mvvmdemo.retrofit

import com.example.mvvmdemo.model.photos.PhotosResponse
import com.example.mvvmdemo.model.users.UsersResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("users")
    fun getUsers() : Call<List<UsersResponseItem>>

    @GET("photos/1")
    fun getPhotos() : Call<PhotosResponse>
}