package com.example.umnuidomikyoyoyo
import kotlinx.serialization.Serializable

@Serializable
data class SmartDataClass(
    val id: Int,
    val Name: String,
    val Address: String,

)
@Serializable
data class User(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val pincode: Int
)
@Serializable
data class Room(
    val id: Int,
    val roomName: String,
    val typeRoomId: Int,
    val houseId: Int
)
@Serializable
data class RoomType(
    val id: Int,
    val name: String
)
@Serializable
data class DevicesTypes(
    val id: Int,
    val name: String,
    val picture: Int? // picture может быть Int, если это ID изображения, или String, если это URL
)
@Serializable
data class Device(
    val id: Int,
    val nameDevice: String,
    val typeDeviceId: Int,
    val roomId: Int,
    val serialNumber: String,
    val isTurn: Boolean,
    val uniqueFunction: String
)
@Serializable
data class DeviceFunq(
    val id: Int,
    val name: String,
    val function1: String,
    val function2: String
)


