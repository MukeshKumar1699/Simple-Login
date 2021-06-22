package com.mukeshproject.simple_login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mukeshproject.simple_login.databinding.ActivityLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var user: User
    private lateinit var binding: ActivityLoginBinding
    private val scope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {

        binding.btnSignUp.setOnClickListener {

            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {

            val email: String = binding.etEmail.text.toString()
            val passwd: String = binding.etPasswd.text.toString()

            scope.launch {
               user =
                   UserDatabase.getInstance(this@LoginActivity).userDao.getUsersPassword(email)
            }
            Toast.makeText(this@LoginActivity, user.password, Toast.LENGTH_SHORT).show()

            if (passwd.equals(user.password)) {

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Name", user.firstName)
                startActivity(intent)
            }
            else {
                binding.etPasswd.error = "Wrong Password"

            }
        }
    }
}