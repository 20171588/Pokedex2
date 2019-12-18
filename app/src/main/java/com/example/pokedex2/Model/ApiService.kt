package com.example.pokedex2.Model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    @GET("pokemon")
    fun obtainPokemon() : Call<PokemonRespuesta>

    @GET
    fun obtainData(@Url url: String) : Call<PokemonRespuesta>

}