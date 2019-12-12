package com.example.pokedex2.Presenter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.example.pokedex2.Contract
import com.example.pokedex2.Model.User
import com.example.pokedex2.View.DashboardView
import com.example.pokedex2.View.LoginView
import com.example.pokedex2.View.RegisterView
import io.realm.Realm

class LoginPresenter(view: LoginView, context: Context) : Contract.Presenter.Login {

    val realm = Realm.getDefaultInstance()
    val view = view
    val context = context

    override fun checkLogin(vusername : String, vpassword : String) {

        if (vusername == "" || vpassword == "") {
            Toast.makeText(context, "Enter Username/Password", Toast.LENGTH_SHORT).show()
        } else {
            var realmResults =
                realm.where(User::class.java).contains("userName", vusername).findFirst()
            if (realmResults == null) {
                Toast.makeText(context, "Username/Password incorrect", Toast.LENGTH_SHORT).show()
            } else {
                if (realmResults.password == vpassword) {
                    Toast.makeText(context, "Log in correctly", Toast.LENGTH_SHORT).show()
                    view.goToDashboard()
                } else {
                    Toast.makeText(context, "Username/Password incorrect", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}