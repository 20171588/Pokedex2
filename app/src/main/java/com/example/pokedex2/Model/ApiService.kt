package com.example.pokedex2.Model

import retrofit2.Call
import retrofit2.http.GET

abstract class ApiService {

    @GET("pokemon")
    abstract fun obtainPokemon() : Call<PokemonRespuesta>

}