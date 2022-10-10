package com.example.mvvmdemo.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmdemo.model.ServicesSetterGetter
import com.example.mvvmdemo.model.photos.PhotosResponse
import com.example.mvvmdemo.model.users.UsersResponseItem
import com.example.mvvmdemo.repository.MainActivityRepository

class MainActivityViewModel : ViewModel() {

    private var servicesLiveData: MutableLiveData<List<UsersResponseItem>>? = null

    fun getUser() : LiveData<List<UsersResponseItem>>? {
        servicesLiveData = MainActivityRepository.getServicesApiCall()
        return servicesLiveData
    }


 /////////////////////////RANDOM IMAGE API///////////////////////////////////////////////////////

    private var imagesLiveData: MutableLiveData<PhotosResponse>? = null

    fun getPhotos() : LiveData<PhotosResponse>? {
        imagesLiveData = MainActivityRepository.getPhotosApiCall()
        return imagesLiveData
    }
}