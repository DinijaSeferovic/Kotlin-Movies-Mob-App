package com.example.cinaeste.mvvm.viewmodel

import com.example.cinaeste.mvvm.data.Movie
import com.example.cinaeste.mvvm.data.MovieRepository

class MovieListViewModel {
    fun getFavoriteMovies():List<Movie>{
        return MovieRepository.getFavoriteMovies();
    }
    fun getRecentMovies():List<Movie> {
        return MovieRepository.getRecentMovies();
    }
}