package com.localmotive.data.entity

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("avatar") val avatar: String,
    @SerializedName("firstname") val firstname: String,
    @SerializedName("id") val id: String,
    @SerializedName("lastname") val lastname: String
)