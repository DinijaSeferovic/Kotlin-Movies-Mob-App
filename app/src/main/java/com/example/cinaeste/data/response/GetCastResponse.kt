package com.example.cinaeste.data.response

import com.example.cinaeste.data.model.Cast
import com.google.gson.annotations.SerializedName

data class GetCastResponse(
    @SerializedName("id") val page: Int,
    @SerializedName("cast") val cast: List<Cast>
)
