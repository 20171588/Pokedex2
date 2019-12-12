package com.example.pokedex2.View

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedex2.Contract
import com.example.pokedex2.Presenter.RegisterPresenter
import com.example.pokedex2.R

class RegisterView : AppCompatActivity(), Contract.View.Register {

    lateinit var presenter : Contract.Presenter.Register
    lateinit var username : EditText
    lateinit var password : EditText
    lateinit var password2 : EditText
    lateinit var register : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        presenter = RegisterPresenter(this,this)
        username = findViewById(R.id.usernameRegister)
        password = findViewById(R.id.passwordRegister)
        password2 = findViewById(R.id.passwordConfirm)

        register = findViewById(R.id.buttonRegister)

        register.setOnClickListener {
            presenter.registerUser(username.text.toString().trim(),password.text.toString().trim(),password2.text.toString().trim())
        }
    }

    override fun goToLogin() {
        finish()
    }
}