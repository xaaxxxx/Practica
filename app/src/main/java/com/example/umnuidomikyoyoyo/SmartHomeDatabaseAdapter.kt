package com.example.umnuidomikyoyoyo

import kotlinx.coroutines.runBlocking
import io.supabase.client.kotlin.SupabaseClient

class SmartHomeDatabaseAdapter (private val supabase: SupabaseClient) {

    val supabaseUrl = "https://brxlipgzawgsmzeqfrwx.supabase.co"
    val supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImJyeGxpcGd6YXdnc216ZXFmcnd4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzE0ODI4NjgsImV4cCI6MjA0NzA1ODg2OH0.a9kYJUJjuo67XQH53VM4kYcnl7l4NUXc9GeNxDWdGxg" // Замените на ваш анонимный ключ

    val supabase = SupabaseClient(supabaseUrl, supabaseKey)
    fun getAllHomes(): List<Home> {
        val result = runBlocking { supabase.from("homes").select("*").execute() }
        return result.map { Home(it.id, it.name, it.address, it.ownerId) }
    }

    fun getHomeById(id: Int): Home? {
        val result = runBlocking { supabase.from("homes").select("*").eq("id", id).execute() }
        return if (result.isEmpty()) null else Home(
            result[0].id,
            result[0].name,
            result[0].address,
            result[0].ownerId
        )
    }

    fun addHome(home: Home): Home {
        val result = runBlocking {
            supabase.from("homes").insert(
                hashMapOf(
                    "name" to home.name,
                    "address" to home.address,
                    "ownerId" to home.ownerId
                )
            ).execute()
        }
        return Home(
            result.data["id"].toString().toInt(),
            result.data["name"].toString(),
            result.data["address"].toString(),
            result.data["ownerId"].toString().toInt()
        )
    }

    fun updateHome(home: Home): Home {
        val result = runBlocking {
            supabase.from("homes").update(hashMapOf("name" to home.name, "address" to home.address))
                .eq("id", home.id).execute()
        }
        return Home(
            result.data["id"].toString().toInt(),
            result.data["name"].toString(),
            result.data["address"].toString(),
            result.data["ownerId"].toString().toInt()
        )
    }

    fun deleteHome(id: Int) = runBlocking { supabase.from("homes").delete().eq("id", id).execute() }


    fun getAllUsers(): List<User> {
        val result = runBlocking { supabase.from("users").select("*").execute() }
        return result.map { User(it.id, it.name, it.email, it.password, it.pincode) }
    }

    fun getUserById(id: Int): User? {
        val result = runBlocking { supabase.from("users").select("*").eq("id", id).execute() }
        return if (result.isEmpty()) null else User(
            result[0].id,
            result[0].name,
            result[0].email,
            result[0].password,
            it.pincode
        )
    }

    fun addUser(user: User): User {
        val result = runBlocking {
            supabase.from("users").insert(
                hashMapOf(
                    "name" to user.name,
                    "email" to user.email,
                    "password" to user.password,
                    "pincode" to user.pincode
                )
            ).execute()
        }
        return User(
            result.data["id"].toString().toInt(),
            result.data["name"].toString(),
            result.data["email"].toString(),
            result.data["password"].toString(),
            result.data["pincode"].toString().toInt()
        )
    }

    fun updateUser(user: User): User {
        val result = runBlocking {
            supabase.from("users").update(
                hashMapOf(
                    "name" to user.name,
                    "email" to user.email,
                    "password" to user.password,
                    "pincode" to user.pincode
                )
            ).eq("id", user.id).execute()
        }
        return User(
            result.data["id"].toString().toInt(),
            result.data["name"].toString(),
            result.data["email"].toString(),
            result.data["password"].toString(),
            result.data["pincode"].toString().toInt()
        )
    }

    fun deleteUser(id: Int) = runBlocking { supabase.from("users").delete().eq("id", id).execute() }


    fun getAllRooms(): List<Room> {
        val result = runBlocking { supabase.from("rooms").select("*").execute() }
        return result.map { Room(it.id, it.room_name, it.type_room_id, it.house_id) }
    }

    fun getRoomById(id: Int): Room? {
        val result = runBlocking { supabase.from("rooms").select("*").eq("id", id).execute() }
        return if (result.isEmpty()) null else Room(
            result[0].id,
            result[0].room_name,
            result[0].type_room_id,
            result[0].house_id
        )
    }

    fun addRoom(room: Room): Room {
        val result = runBlocking {
            supabase.from("rooms").insert(
                hashMapOf(
                    "room_name" to room.room_name,
                    "type_room_id" to room.type_room_id,
                    "house_id" to room.house_id
                )
            ).execute()
        }
        return Room(
            result.data["id"].toString().toInt(),
            result.data["room_name"].toString(),
            result.data["type_room_id"].toString().toInt(),
            result.data["house_id"].toString().toInt()
        )
    }

    fun updateRoom(room: Room): Room {
        val result = runBlocking {
            supabase.from("rooms").update(
                hashMapOf(
                    "room_name" to room.room_name,
                    "type_room_id" to room.type_room_id,
                    "house_id" to room.house_id
                )
            ).eq("id", room.id).execute()
        }
        return Room(
            result.data["id"].toString().toInt(),
            result.data["room_name"].toString(),
            result.data["type_room_id"].toString().toInt(),
            result.data["house_id"].toString().toInt()
        )
    }

    fun deleteRoom(id: Int) = runBlocking { supabase.from("rooms").delete().eq("id", id).execute() }

    // Функции для таблицы "Типы комнат"
    fun getAllRoomTypes(): List<RoomType> {
        val result = runBlocking { supabase.from("room_types").select("*").execute() }
        return result.map { RoomType(it.id, it.name) }
    }

    fun getRoomTypeById(id: Int): RoomType? {
        val result = runBlocking { supabase.from("room_types").select("*").eq("id", id).execute() }
        return if (result.isEmpty()) null else RoomType(result[0].id, result[0].name)
    }

    fun addRoomType(roomType: RoomType): RoomType {
        val result = runBlocking {
            supabase.from("room_types").insert(hashMapOf("name" to roomType.name)).execute()
        }
        return RoomType(result.data["id"].toString().toInt(), result.data["name"].toString())
    }

    fun updateRoomType(roomType: RoomType): RoomType {
        val result = runBlocking {
            supabase.from("room_types").update(hashMapOf("name" to roomType.name))
                .eq("id", roomType.id).execute()
        }
        return RoomType(result.data["id"].toString().toInt(), result.data["name"].toString())
    }

    fun deleteRoomType(id: Int) =
        runBlocking { supabase.from("room_types").delete().eq("id", id).execute() }

    // Функции для таблицы "Типы устройств"
    fun getAllDeviceTypes(): List<DeviceType> {
        val result = runBlocking { supabase.from("device_types").select("*").execute() }
        return result.map { DeviceType(it.id, it.name) }
    }

    fun getDeviceTypeById(id: Int): DeviceType? {
        val result =
            runBlocking { supabase.from("device_types").select("*").eq("id", id).execute() }
        return if (result.isEmpty()) null else DeviceType(result[0].id, result[0].name)
    }

    fun addDeviceType(deviceType: DeviceType): DeviceType {
        val result = runBlocking {
            supabase.from("device_types").insert(hashMapOf("name" to deviceType.name)).execute()
        }
        return DeviceType(result.data["id"].toString().toInt(), result.data["name"].toString())
    }

    fun updateDeviceType(deviceType: DeviceType): DeviceType {
        val result = runBlocking {
            supabase.from("device_types").update(hashMapOf("name" to deviceType.name)).eq("id")
        }
    }
}