package com.mukeshproject.simple_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mukeshproject.simple_login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.text.text = intent.getStringExtra("Name")

    }
}