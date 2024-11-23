package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class AdressActivity : AppCompatActivity() {

    private lateinit var edit3page1: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adress)
edit3page1 = findViewById(R.id.edit3page1)

val supa = createSupabaseClient(
            supabaseUrl = "https://brxlipgzawgsmzeqfrwx.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImJyeGxpcGd6YXdnc216ZXFmcnd4Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzE0ODI4NjgsImV4cCI6MjA0NzA1ODg2OH0.a9kYJUJjuo67XQH53VM4kYcnl7l4NUXc9GeNxDWdGxg"
        ) {
            install(Postgrest)
        }



        val edit3page1: EditText = findViewById(R.id.edit3page1)
        val sohranbutton: Button = findViewById(R.id.sohranbutton)




        sohranbutton.setOnClickListener {
            val inputText = edit3page1.text.toString()

            MainScope().launch {
                val response = SmartDataClass(id=4, Name="valeralox", Address=edit3page1.text.toString())
                supa.from("Homes").insert(response)
            }
            val regex = Regex("""^.*\s*,\s*ul\.\s*.*\s*,\s*d\.\s*\d+$""")

            if (regex.matches(inputText)) {
                // Адрес валидный



                val address = edit3page1.text.toString()
                val intent = Intent(this, MainPage::class.java)
                intent.putExtra("address", address)
                startActivity(intent)

                startActivity(intent)
            } else {

                Toast.makeText(
                    this,
                    "Неверный формат адреса. Введите адрес в формате:\nГород, ul. Улица, d. Номер дома",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}