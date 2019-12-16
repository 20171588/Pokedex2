package com.example.pokedex2.Presenter

import android.util.Log
import com.example.pokedex2.Contract
import com.example.pokedex2.Model.ApiService
import com.example.pokedex2.Model.PokedexModel
import com.example.pokedex2.Model.PokemonRespuesta
import com.example.pokedex2.View.PokedexView
import kotlinx.android.synthetic.main.activity_pokedex.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokedexPresenter(model: PokedexModel,view: PokedexView) : Contract.Presenter.Pokedex{

    val model = model
    val view = view

    override fun nextPokemon() {
        if (model.index == model.pokemonList.size-1){
            model.index = 0
            model.actualPokemon = model.pokemonList[model.index]
        }else {
            model.index += 1
            model.actualPokemon = model.pokemonList[model.index]
        }
    }

    override fun backPokemon() {
        if (model.index == 0){
            model.index = model.pokemonList.size-1
            model.actualPokemon = model.pokemonList[model.index]
        }else {
            model.index -= 1
            model.actualPokemon = model.pokemonList[model.index]
        }
    }

    override fun obtainPokemon() {
        val service = view.retrofit.create<ApiService>(ApiService::class.java)
        var pokemonRespuestaCall = service.obtainPokemon()

        pokemonRespuestaCall.enqueue(object : Callback<PokemonRespuesta> {

            override fun onFailure(call: Call<PokemonRespuesta>, t: Throwable) {

                Log.e("Pokedex","On failure: "+t.message)
            }

            override fun onResponse(
                call: Call<PokemonRespuesta>,
                response: Response<PokemonRespuesta>
            ) { if (response.isSuccessful){

                    var pokemonRespuesta = response.body()
                    model.pokemonList = pokemonRespuesta!!.results
                    setPokemon()
                }else{
                    Log.e("Pokedex","On failure: " + response.errorBody())
                }
            }
        }
        )
    }

    override fun setPokemon() {
        view.name = model.actualPokemon.name
    }
}