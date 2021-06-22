package com.mukeshproject.simple_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RestrictTo
import com.mukeshproject.simple_login.databinding.ActivitySignUpBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    private val scope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {


        binding.btnSignUp.setOnClickListener {

            name = binding.etName.text.toString()
            email = binding.etEmail.text.toString()

            if (binding.etPasswd.text.toString().equals(binding.etConfirmPasswd.text.toString())) {

                password = binding.etPasswd.text.toString()
                val user = User(userId = 0, name, email, password)

                scope.launch {
                    UserDatabase.getInstance(this@SignUpActivity).userDao.insertUser(user)

                }
                Toast.makeText(this, "account Created", Toast.LENGTH_SHORT).show()
                finish()
            }
            else {
                binding.etConfirmPasswd.error = "Password Miss match"
            }
        }

    }

    companion object {

        private lateinit var name:String
        private lateinit var email:String
        private lateinit var password:String


    }
}