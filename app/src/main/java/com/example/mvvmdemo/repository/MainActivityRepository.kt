package com.example.mvvmdemo.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mvvmdemo.model.photos.PhotosResponse
import com.example.mvvmdemo.model.users.UsersResponseItem
import com.example.mvvmdemo.retrofit.RetrofitClient
import com.example.mvvmdemo.view.logThis
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {
    val serviceSetterGetter = MutableLiveData<List<UsersResponseItem>>()

    fun getServicesApiCall(): MutableLiveData<List<UsersResponseItem>> {

        val call = RetrofitClient.apiInterface.getUsers()

        call.enqueue(object : Callback<List<UsersResponseItem>> {
            override fun onFailure(call: Call<List<UsersResponseItem>>, t: Throwable) {
                Log.v("DEBUG : ", t.stackTraceToString())
            }

            override fun onResponse(
                call: Call<List<UsersResponseItem>>,
                response: Response<List<UsersResponseItem>>
            ) {
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                data?.let {
                    serviceSetterGetter.value = it
                }
            }
        })

        return serviceSetterGetter
    }


    val photosSetterGetter = MutableLiveData<PhotosResponse>()

    fun getPhotosApiCall(): MutableLiveData<PhotosResponse> {

        val call = RetrofitClient.apiInterface.getPhotos()

        call.enqueue(object : Callback<PhotosResponse> {
            override fun onFailure(call: Call<PhotosResponse>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<PhotosResponse>,
                response: Response<PhotosResponse>
            ) {
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                data?.let {
                    photosSetterGetter.value = it
                }
            }
        })

        return photosSetterGetter
    }
}