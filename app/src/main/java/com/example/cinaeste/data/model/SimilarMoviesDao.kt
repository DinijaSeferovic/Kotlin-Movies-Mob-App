package com.example.cinaeste.data.model

import androidx.room.*

@Dao

interface SimilarMoviesDao {

    @Insert(onConflict=OnConflictStrategy.IGNORE)
    suspend fun insert(join:SimilarMovies)

    @Transaction
    @Delete
    suspend fun deleteSimilar(join:SimilarMovies)

    @Transaction
    @Delete
    suspend fun deleteSimilarMovies(smovies:List<Movie>)

}