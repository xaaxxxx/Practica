package com.example.umnuidomikyoyoyo

import android.app.Application
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object scauth : Application() {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://epnpmubjkppfvwaujvgp.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImVwbnBtdWJqa3BwZnZ3YXVqdmdwIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzEzOTU1MDUsImV4cCI6MjA0Njk3MTUwNX0.tIpeeS_U637ykOloIDwFJrgVpEjceaoE4BKSrhDZx5Y"
    ) {
        install(Auth)
        install(Postgrest)
    }
    public fun getSB() : SupabaseClient {
        return supabase
    }
}