package com.example.pokedex2.View

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedex2.Contract
import com.example.pokedex2.Model.CatchModel
import com.example.pokedex2.Model.PokedexModel
import com.example.pokedex2.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_catchit.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CatchItView : AppCompatActivity(), Contract.View.CatchIt{

    lateinit var retrofit: Retrofit
    var model = CatchModel()
    var modelPoke = PokedexModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catchit)

        retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        var url = intent.getStringExtra("url")
        var position = intent.getIntExtra("position",-1)
        var picasso = Picasso.get()
        picasso.load(url).into(pokecatch)

        pokecatch.setOnClickListener {
            //presenter.updateData(model.pokeArray,position!!.toInt())
            //catch(position!!.toInt())
            goToPokedex()
        }
    }

    override fun catch(position : Int) {
        modelPoke.pokemonList.add(model.pokeArray[position])
    }

    override fun goToPokedex(){
        var intent = Intent(this,PokedexView::class.java)
        startActivity(intent)
    }
}