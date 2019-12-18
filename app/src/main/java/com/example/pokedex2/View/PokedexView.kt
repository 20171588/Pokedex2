package com.example.pokedex2.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedex2.Contract
import com.example.pokedex2.Model.PokedexModel
import com.example.pokedex2.Model.Pokemon
import com.example.pokedex2.Presenter.PokedexPresenter
import com.example.pokedex2.R
import org.w3c.dom.Text
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokedexView : AppCompatActivity(), Contract.View.Pokedex {

    lateinit var retrofit: Retrofit
    val model = PokedexModel()
    var presenter: PokedexPresenter = PokedexPresenter(model,this)
    lateinit var name: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokedex)

        name = findViewById(R.id.name)
        val menu : Button = findViewById(R.id.menu)


        retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/pokemon/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        menu.setOnClickListener {
            goToMenu()
        }


    }

    override fun goToMenu() {
        var intent = Intent(this,DashboardView::class.java)
        startActivity(intent)
    }
}