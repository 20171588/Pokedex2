package com.example.pokedex2.Presenter

import android.util.Log
import com.example.pokedex2.Contract
import com.example.pokedex2.Model.*
import com.example.pokedex2.View.CatchAdapter
import com.example.pokedex2.View.CatchView
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_catch.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatchPresenter(view: CatchView,model: CatchModel) : Contract.Presenter.Catch {

    val realm = Realm.getDefaultInstance()
    val view = view
    val model = model

    fun obtainPokemon() {
        val service = view.retrofit.create<ApiService>(ApiService::class.java)
        var pokemonRespuestaCall: Call<PokemonRespuesta> = service.obtainPokemon()

        pokemonRespuestaCall.enqueue(object : Callback<PokemonRespuesta> {

            override fun onFailure(call: Call<PokemonRespuesta>, t: Throwable) {

                Log.e("Pokedex","On failure: "+t.message)
            }

            override fun onResponse(
                call: Call<PokemonRespuesta>,
                response: Response<PokemonRespuesta>
            ) { if (response.isSuccessful){

                var pokemonRespuesta = response.body()
                model.pokeArray = pokemonRespuesta!!.results
                view.adapter = CatchAdapter(model.pokeArray,view)
                view.pokegrid.adapter = view.adapter
                Log.i("Pokedex",model.pokeArray[0].name)
                updateData(model.pokeArray,0)
                Log.i("Pokedex",model.pokeArray[0].base_experience)
            }else{
                Log.e("Pokedex","On failure: " + response.errorBody())
            }
            }
        }
        )
    }

    override fun updateData(lista: ArrayList<Pokemon>, posicion : Int) {
        val service = view.retrofit.create<ApiService>(ApiService::class.java)
        var pokemonRespuestaCall = service.obtainData("pokemon/"+(posicion+1).toString())

        pokemonRespuestaCall.enqueue(object : Callback<PokemonRespuesta> {

            override fun onFailure(call: Call<PokemonRespuesta>, t: Throwable) {

                Log.e("Pokedex","On failure: "+t.message)
            }

            override fun onResponse(
                call: Call<PokemonRespuesta>,
                response: Response<PokemonRespuesta>
            ) { if (response.isSuccessful){
                var pokemonRespuesta =response.body()
                lista[posicion].name = pokemonRespuesta!!.name
                lista[posicion].base_experience = pokemonRespuesta!!.base_experience
                lista[posicion].sprite = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${posicion+1}.png"
            }else{
                Log.e("Pokedex","On failure: " + response.errorBody())
            }
            }
        }
        )
    }
}