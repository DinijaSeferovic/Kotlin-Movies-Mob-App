package com.example.cinaeste.viewmodel

import com.example.cinaeste.data.Movie
import com.example.cinaeste.data.MovieRepository

class MovieListViewModel {
    fun getFavoriteMovies():List<Movie>{
        return MovieRepository.getFavoriteMovies();
    }
    fun getRecentMovies():List<Movie> {
        return MovieRepository.getRecentMovies();
    }
}