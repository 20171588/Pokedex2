package com.example.pokedex2.Model

import io.realm.RealmObject

open class User() : RealmObject() {

    var userName : String = ""
    var password : String = ""

}