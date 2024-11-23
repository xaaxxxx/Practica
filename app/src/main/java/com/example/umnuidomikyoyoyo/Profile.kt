package com.example.umnuidomikyoyoyo

import kotlinx.serialization.Serializable

@Serializable
data class Profiles(

    val id: String,
    val first_name: String,
    val last_name: String,
    val adress: String
)