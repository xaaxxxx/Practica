package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AdressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adress)

        val addressEditText = findViewById<EditText>(R.id.edit3page1)
        val saveButton = findViewById<Button>(R.id.sohranbutton)

        saveButton.setOnClickListener {
            val address = addressEditText.text.toString().trim()

            if (isValidAddress(address)) {
                // Валидация пройдена, выполните сохранение
                Toast.makeText(this, "Адрес сохранен!", Toast.LENGTH_SHORT).show()
                // Переход на следующую Activity
                val intent = Intent(this, HouseActivity::class.java) // Замените NextActivity на нужное имя
                startActivity(intent)
            } else {
                // Отобразите сообщение об ошибке
                Toast.makeText(this, "Неверный формат адреса", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidAddress(address: String): Boolean {
        // Проверяем на наличие всех необходимых частей в адресе
        val hasCity = address.contains("г.")
        val hasStreet = address.contains("ул.")
        val hasHouseNumber = address.contains("д.")

        if (!hasCity || !hasStreet || !hasHouseNumber) {
            return false
        }

        // Разделяем адрес по запятым
        val parts = address.split(", ")

        // Проверяем, что адрес состоит из 4 частей
        if (parts.size != 4) {
            return false
        }

        // Проверяем, что в "г.", "ул.", "д." нет лишних символов
        if (parts[0].substring(0, 2) != "г." || parts[1].substring(0, 3) != "ул." || parts[2].substring(0, 2) != "д.") {
            return false
        }

        // Дополнительные проверки (например, на наличие цифр в "Номер дома")
        // ...

        return true
    }
}