package com.example.pokedex2.Presenter

import android.content.Context
import android.widget.EditText
import android.widget.Toast
import com.example.pokedex2.Contract
import com.example.pokedex2.Model.User
import com.example.pokedex2.R
import com.example.pokedex2.View.RegisterView
import io.realm.Realm

class RegisterPresenter(view : RegisterView, context: Context) : Contract.Presenter.Register{

    val realm = Realm.getDefaultInstance()
    val context = context
    val view = view


    override fun registerUser(vusername:String, vpassword:String, vpassword2: String){

        if (vusername=="" || vpassword=="" || vpassword2 == ""){
            Toast.makeText(context,"Enter username / password", Toast.LENGTH_SHORT).show()
        }else{
            if (vpassword == vpassword2) {
                realm.beginTransaction()
                val user = realm.createObject(User::class.java)
                user.userName = vusername
                user.password = vpassword
                realm.commitTransaction()
                Toast.makeText(context, "Register successful", Toast.LENGTH_SHORT).show()
                view.goToLogin()
            }else{
                Toast.makeText(context, "Password don't match", Toast.LENGTH_SHORT).show()
            }
        }
    }
}