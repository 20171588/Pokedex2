package com.example.pokedex2.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.pokedex2.Contract
import com.example.pokedex2.Presenter.LoginPresenter
import com.example.pokedex2.R

class LoginView : AppCompatActivity() , Contract.View.Login {

    lateinit var presenter: Contract.Presenter.Login
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var register: Button
    lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        register = findViewById(R.id.register)
        login = findViewById(R.id.login)

        presenter = LoginPresenter(this, this)

        register.setOnClickListener { goToRegister() }
        login.setOnClickListener { presenter.checkLogin(username.text.toString().trim(),password.text.toString().trim()) }

    }

    override fun goToDashboard() {
        var intent = Intent(this,DashboardView::class.java)
        ContextCompat.startActivity(this, intent, null)
    }

    override fun goToRegister() {
        var intent = Intent(this,RegisterView::class.java)
        ContextCompat.startActivity(this, intent, null)
    }
}