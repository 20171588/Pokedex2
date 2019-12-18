package com.example.pokedex2.Presenter

import android.util.Log
import com.example.pokedex2.Contract
import com.example.pokedex2.Model.ApiService
import com.example.pokedex2.Model.PokedexModel
import com.example.pokedex2.Model.Pokemon
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
        }else {
            model.index += 1
        }
    }

    override fun backPokemon() {
        if (model.index == 0){
            model.index = model.pokemonList.size-1
        }else {
            model.index -= 1
        }
    }

    /*override fun obtainPokemon() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }*/

    /*override fun obtainData(url : String) {
        val service = view.retrofit.create<ApiService>(ApiService::class.java)
        var pokemonRespuestaCall = service.obtainData(url)

        pokemonRespuestaCall.enqueue(object : Callback<PokemonRespuesta> {

            override fun onFailure(call: Call<PokemonRespuesta>, t: Throwable) {

                Log.e("Pokedex","On failure: "+t.message)
            }

            override fun onResponse(
                call: Call<PokemonRespuesta>,
                response: Response<PokemonRespuesta>
            ) { if (response.isSuccessful){

                    var pokemonRespuesta = response.body()
                    model.pokemonList.add(Pokemon(pokemonRespuesta!!.name,pokemonRespuesta!!.order))
                    view.name.text = model.pokemonList[model.index].name

                }else{
                    Log.e("Pokedex","On failure: " + response.errorBody())
                }
            }
        }
        )
    }*/

    override fun setPokemon() {
        view.name.text = model.pokemonList[model.index].name
    }
}