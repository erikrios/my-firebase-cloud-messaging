package com.erikriosetiawan.myfirebasecloudmessaging

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erikriosetiawan.myfirebasecloudmessaging.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}