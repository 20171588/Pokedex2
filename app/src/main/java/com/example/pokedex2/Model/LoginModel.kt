package com.example.pokedex2.Model

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class LoginModel : Application(){

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        var config =  RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build()
        Realm.setDefaultConfiguration(config)
    }
}