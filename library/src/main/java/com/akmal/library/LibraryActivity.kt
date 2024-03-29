package com.akmal.library

import android.accounts.AuthenticatorException
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.akmal.library.databinding.ActivityLibraryBinding

class LibraryActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityLibraryBinding::bind)

    @RequiresApi(Build.VERSION_CODES.ECLAIR)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        if (applicationContext.packageName.startsWith("com.akmal")) {
            Toast.makeText(this, "version:1.4", Toast.LENGTH_SHORT).show()
            initCLickActions()
        } else {
            throw AuthenticatorException("f**k off, mate")
        }
    }

    private fun initCLickActions() {
        binding.btn.setOnClickListener {
            if (Validator().getInstance().isValid(binding.editText.text.toString())) {
                Toast.makeText(this, "email is valid", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "email is invalid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}