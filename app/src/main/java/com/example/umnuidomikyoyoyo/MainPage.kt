package com.example.umnuidomikyoyoyo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

private lateinit var textViewHouse: TextView

class MainPage : AppCompatActivity(){
    private lateinit var roomTextView: TextView
    private lateinit var deviceTextView: TextView
    private lateinit var userTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainpage)

        textViewHouse = findViewById(R.id.texthouse)

        val intent = intent
        if (intent != null) {
            val address = intent.getStringExtra("address")
            textViewHouse.text = address
        }

        roomTextView = findViewById(R.id.roomsTextView) //id
        deviceTextView = findViewById(R.id.devicesTextView)
        userTextView= findViewById(R.id.usersTextView)

        val fragments = mapOf(
            R.id.roomsTextView to HouseActivity(),
            R.id.devicesTextView to DeviceActivity(),
            R.id.usersTextView to FamilyActivity()
        )
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,
            fragments[R.id.roomsTextView]!! as Fragment
        ).commit()

        roomTextView.setOnClickListener { switchFragment(fragments[R.id.roomsTextView]!!) }
        deviceTextView.setOnClickListener { switchFragment(fragments[R.id.devicesTextView]!!) }
        userTextView.setOnClickListener { switchFragment(fragments[R.id.usersTextView]!!) }
    }


    private fun switchFragment(fragment: Any) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment as Fragment)
        transaction.commit()
    }
}