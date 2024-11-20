package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AdressActivity : AppCompatActivity() {

    private lateinit var edit3page1: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adress)






        val edit3page1: EditText = findViewById(R.id.edit3page1)
        val sohranbutton: Button = findViewById(R.id.sohranbutton)




        sohranbutton.setOnClickListener {
            val inputText = edit3page1.text.toString()


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