package com.example.mvvmdemo.view

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.R
import com.example.mvvmdemo.adapter.RecyclerViewAdapter
import com.example.mvvmdemo.viewmodel.MainActivityViewModel


class MainActivity : AppCompatActivity() {

    private var btnClick: Button? = null
        get() = findViewById(R.id.btnClick)
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private var recyclerView: RecyclerView? = null
        get() = findViewById(R.id.rvData)
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView?.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerViewAdapter = RecyclerViewAdapter()
        recyclerView?.adapter = recyclerViewAdapter


        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        btnClick?.setOnClickListener {
            mainActivityViewModel.getUser()?.observe(this) { serviceSetterGetter ->
                val msg = serviceSetterGetter.results
                recyclerViewAdapter.setList(msg)
            }
        }
    }
}