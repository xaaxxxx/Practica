package com.example.umnuidomikyoyoyo
import io.github.jan.supabase.auth.Auth
import io.ktor.websocket.WebSocketDeflateExtension.Companion.install
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseClient {

    val supabase = createSupabaseClient(
        supabaseUrl = "https://brxlipgzawgsmzeqfrwx.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImJyeGxpcGd6YXdnc216ZXFmcnd4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzE0ODI4NjgsImV4cCI6MjA0NzA1ODg2OH0.a9kYJUJjuo67XQH53VM4kYcnl7l4NUXc9GeNxDWdGxg"
    ) {
        install(Auth)
        install(Postgrest)
    }

}

