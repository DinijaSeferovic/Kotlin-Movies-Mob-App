package com.example.cinaeste

import android.telecom.Call.Details.hasProperty
import com.example.cinaeste.data.Movie
import com.example.cinaeste.data.MovieRepository

import org.hamcrest.CoreMatchers.`is` as Is

import junit.framework.Assert.assertEquals
import org.hamcrest.Matchers.*
import org.junit.Assert.assertThat
import org.junit.Test

class RepositoryUnitTest {

    @Test
    fun testGetFavoriteMovies(){
        val movies = MovieRepository.getFavoriteMovies()
        assertEquals(movies.size,3)
        assertThat(movies, hasItem<Movie>(hasProperty("title", Is("In time"))))
        assertThat(movies, not(hasItem<Movie>(hasProperty("title", Is("Black Widow")))))
    }

    @Test
    fun testGetRecentMovies (){
        val movies = MovieRepository.getRecentMovies()
        assertEquals(movies.size,3)
        assertThat(movies, hasItem<Movie>(hasProperty("title", Is("Nobody"))))
        assertThat(movies, not(hasItem<Movie>(hasProperty("title", Is("Black Widow")))))
    }

}