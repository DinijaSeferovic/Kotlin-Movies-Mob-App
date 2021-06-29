package com.example.cinaeste.data.repository

import com.example.cinaeste.BuildConfig
import com.example.cinaeste.data.api.ApiAdapter
import com.example.cinaeste.data.response.GetCastResponse
import com.example.cinaeste.data.movieActors
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object ActorMovieRepository {

    /*fun getActorMovies():Map<String,List<String>>{
        return movieActors()
    } -- do vjezbe 5*/


    private const val tmdb_api_key = BuildConfig.TMDB_API_KEY
    fun getActorMovies():Map<String,List<String>>{
        return movieActors()
    }

    //Retrofit coroutines
    suspend fun getCast( id: Long
    ) : GetCastResponse?{
        return withContext(Dispatchers.IO) {
            var response = ApiAdapter.retrofit.getCast(id)
            val responseBody = response.body()
            return@withContext responseBody
        }
    }



}


