package com.example.pokedex2.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedex2.Contract
import com.example.pokedex2.R

class DashboardView : AppCompatActivity(), Contract.View.DashBoard{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        var botonPoke = findViewById<Button>(R.id.goPokedex)
        var botonCatch = findViewById<Button>(R.id.goCatch)

        botonPoke.setOnClickListener {
            goToPokedex()
        }

        botonCatch.setOnClickListener {
            goToCatch()
        }
    }

    override fun goToPokedex(){
        var intent = Intent(this,PokedexView::class.java)
        startActivity(intent)
    }

    override fun goToCatch() {
        var intent = Intent(this,CatchView::class.java)
        startActivity(intent)
    }


}