package com.dicoding.mysimplelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dicoding.core.SessionManager
import com.dicoding.core.UserRepository
import com.dicoding.mysimplelogin.databinding.ActivityHomeBinding
import java.lang.Exception

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sesi = SessionManager(this)
        userRepository = UserRepository.getInstance(sesi)

        binding.tvWelcome.text = "Welcome ${userRepository.getUser()}"

        binding.btnLogout.setOnClickListener {
            userRepository.logoutUser()
            moveToMainActivity()
        }

        binding.fab.setOnClickListener{
            try{
                moveToMainActivity()
            }catch (e: Exception){
                Toast.makeText(this, "Module Not Found", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun moveToMainActivity() {
        startActivity(Intent(this, Class.forName("com.dicoding.mysimplelogin.chat.Chatactivity")))
        finish()
    }
}
