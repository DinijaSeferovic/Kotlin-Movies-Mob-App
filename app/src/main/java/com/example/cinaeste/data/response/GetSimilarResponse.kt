package com.example.cinaeste.data.response

import com.example.cinaeste.data.model.Movie
import com.google.gson.annotations.SerializedName

data class GetSimilarResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movie>
)
