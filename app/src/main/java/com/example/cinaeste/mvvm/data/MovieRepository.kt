package com.example.cinaeste.mvvm.data

import com.example.cinaeste.data.favoriteMovies
import com.example.cinaeste.data.recentMovies

object MovieRepository {
    fun getFavoriteMovies() : List<Movie> {
        return favoriteMovies();
    }
    fun getRecentMovies() : List<Movie> {
        return recentMovies();
    }
}