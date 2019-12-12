package com.example.pokedex2

import android.content.Context
import android.widget.EditText

interface Contract {

    interface Model{

    }

    interface Presenter {

        interface Login{
            fun checkLogin(vusername: String, vpassword: String)
        }


        interface Register{
            fun registerUser(vusername: String, vpassword: String, vpassword2: String)
        }


    }

    interface View {

        interface Login{
            fun goToDashboard()
            fun goToRegister()
        }

        interface Register{
            fun goToLogin()
        }

        interface DashBoard{

        }

    }
}