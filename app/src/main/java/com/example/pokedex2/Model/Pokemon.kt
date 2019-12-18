package com.example.pokedex2.Model

import io.realm.RealmObject

open class Pokemon : RealmObject() {

    var name : String = ""
    var url : String = ""
    var base_experience = ""
    var type : String = ""
    var sprite : String = ""
}