package com.example.pokedex2.View

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.pokedex2.Contract
import com.example.pokedex2.Model.CatchModel
import com.example.pokedex2.Presenter.CatchPresenter
import com.example.pokedex2.R
import kotlinx.android.synthetic.main.activity_catch.*
import kotlinx.android.synthetic.main.pokecatch.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatchView : AppCompatActivity(), Contract.View.Catch {

    lateinit var retrofit: Retrofit
    var model: CatchModel = CatchModel()
    val presenter = CatchPresenter(this,model)
    lateinit var adapter : CatchAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catch)

        retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        presenter.obtainPokemon()
    }

    override fun goToCatchIt() {
        var intent = Intent(this,CatchItView::class.java)
        startActivity(intent)
    }
}