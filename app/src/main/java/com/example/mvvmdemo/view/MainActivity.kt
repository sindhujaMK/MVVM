package com.example.mvvmdemo.view

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.mvvmdemo.adapter.RecyclerViewAdapter
import com.example.mvvmdemo.databinding.ActivityMainBinding
import com.example.mvvmdemo.viewmodel.MainActivityViewModel


class MainActivity : AppCompatActivity() {
    //this is the variable instantiated for view binding. viewbinding can be used instead of findViewById. it is turned on in build.gradle file
    private var binding: ActivityMainBinding? = null

    private var recyclerViewAdapter: RecyclerViewAdapter? = null
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        init()
        initViews()
        handleEvents()
    }


    private fun init() {
        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        recyclerViewAdapter = RecyclerViewAdapter()
    }

    private fun initViews() {
        binding?.rvData?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = recyclerViewAdapter
        }
    }


    private fun handleEvents() {

        binding?.btnClick?.setOnClickListener {

            binding?.progressBar?.visibility = View.VISIBLE

            mainActivityViewModel.getUser()?.observe(this) { result ->
                logThis("response: $result")
                result?.let {
                    recyclerViewAdapter?.setList(it)

                    binding?.progressBar?.visibility = View.GONE
                }
            }
        }

        binding?.btnRandomImage?.setOnClickListener {

            binding?.progressBar?.visibility = View.VISIBLE

            mainActivityViewModel.getPhotos()?.observe(this) { result ->
                binding?.imageView?.load(result?.url)
                binding?.progressBar?.visibility = View.GONE
            }
        }
    }

}

fun logThis(message: Any?) {
    Log.d("logThis", "-->: $message")
}