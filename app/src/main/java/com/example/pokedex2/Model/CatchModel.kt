package com.example.pokedex2.Model

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class CatchModel : Application(){

    var pokeArray : ArrayList<Pokemon> = ArrayList()
}