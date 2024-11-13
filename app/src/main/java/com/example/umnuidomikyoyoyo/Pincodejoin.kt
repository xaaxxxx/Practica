package com.example.umnuidomikyoyoyo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class Pincodejoin : AppCompatActivity()  {
    private var counter = 0
    private var password = ""
    private lateinit var massive1: IntArray
    private lateinit var circlesLinearLayout: LinearLayout
    private lateinit var circle1: ImageView
    private lateinit var circle2: ImageView
    private lateinit var circle3: ImageView
    private lateinit var circle4: ImageView
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pincodejoin)



        // Инициализируем массив
        massive1 = IntArray(4) { -1 }


        circlesLinearLayout = findViewById(R.id.circleslinear)
        circle1 = findViewById(R.id.circle1)
        circle2 = findViewById(R.id.circle2)
        circle3 = findViewById(R.id.circle3)
        circle4 = findViewById(R.id.circle4)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)








        // Установка обработчиков кликов для кнопок
        button1.setOnClickListener { updateCircles(it, true) }
        button2.setOnClickListener { updateCircles(it, true) }
        button3.setOnClickListener { updateCircles(it, true) }
        button4.setOnClickListener { updateCircles(it, true) }
        button5.setOnClickListener { updateCircles(it, true) }
        button6.setOnClickListener { updateCircles(it, true) }
        button7.setOnClickListener { updateCircles(it, true) }
        button8.setOnClickListener { updateCircles(it, true) }
        button9.setOnClickListener { updateCircles(it, true) }



    }

    private fun updateCircles(view: View, isAdd: Boolean) {
        password = ""
        val button = view as Button

        if (counter < 4 && isAdd) {
            counter++
            massive1[counter - 1] = button.text.toString().toInt()
        }

        // Обновление кругов
        if (counter > 0) {
            circle1.setBackgroundResource(R.drawable.bluecircle2)
        } else {
            circle1.setBackgroundResource(R.drawable.whitecircle)
        }
        if (counter > 1) {
            circle2.setBackgroundResource(R.drawable.bluecircle2)
        } else {
            circle2.setBackgroundResource(R.drawable.whitecircle)
        }
        if (counter > 2) {
            circle3.setBackgroundResource(R.drawable.bluecircle2)
        } else {
            circle3.setBackgroundResource(R.drawable.whitecircle)
        }
        if (counter > 3) {
            circle4.setBackgroundResource(R.drawable.bluecircle2)
        } else {
            circle4.setBackgroundResource(R.drawable.whitecircle)
        }

        // Сбор пароля
        password = massive1.joinToString("") { it.toString() }

        // Проверка пин-кода, если введен полностью
        if (counter == 4) {
            checkPinCode(password)
        }
    }

    // Функция для удаления цифры
    fun deletedCircles(view: View) {
        if (counter > 0) {
            counter--
            massive1[counter] = -1
        }
        updateCircles(view, false) // Вызываем updateCircles с isAdd = false для удаления
    }

    // Функция для проверки пин-кода (еще не реализована)
    private fun checkPinCode(password: String) {
        val correctPinCode = password
        val sharedPreferences = getSharedPreferences("ACCOUNT_DETAILS", 0)
        with(sharedPreferences.edit()) {
            putString("PASSWORD", correctPinCode)
            apply()
        }



        startActivity(Intent(this, AdressActivity::class.java))
        finish()
    }


}