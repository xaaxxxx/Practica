package com.example.umnuidomikyoyoyo

data class RoomData(
    val id: Int,
    val roomName: String,
    val typeRoomId: Int,
    val typeRoomName: String? = null, // Добавлено для названия типа комнаты
    val roomImage: Int? = null    // Добавлено для изображения комнаты
)