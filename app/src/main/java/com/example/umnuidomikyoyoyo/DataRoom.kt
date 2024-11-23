package com.example.umnuidomikyoyoyo
import kotlinx.serialization.Serializable

@Serializable
data class DataRooms(
    val id: Int,
    val room_name: String,
    val type_room_id: Int,
    val house_id: String,

    )
