package com.example.pokedex2.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedex2.Contract
import com.example.pokedex2.R

class DashboardView : AppCompatActivity(), Contract.View.DashBoard{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }
}