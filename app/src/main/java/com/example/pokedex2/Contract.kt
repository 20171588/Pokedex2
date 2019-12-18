package com.example.pokedex2

import com.example.pokedex2.Model.Pokemon

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

        interface Pokedex{
            fun nextPokemon()
            fun backPokemon()
            fun setPokemon()

        }

        interface Catch{
            fun updateData(list: ArrayList<Pokemon>, position:Int)
        }
        interface CatchIt{

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
            fun goToPokedex()
            fun goToCatch()
        }

        interface Pokedex{
            fun goToMenu()
        }

        interface Catch{
            fun goToCatchIt()
        }

        interface CatchIt{
            fun goToPokedex()
            fun catch(position: Int)
        }

    }
}