package com.akmal.librarydemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.akmal.library.LibraryActivity
import com.akmal.librarydemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCLickActions()
    }

    private fun initCLickActions() {
        binding.button.setOnClickListener {
            try {
                startActivity(Intent(this, LibraryActivity::class.java))
            } catch (e: Exception) {
                Log.d("Imola", e.message.toString())
            }
        }
    }
}