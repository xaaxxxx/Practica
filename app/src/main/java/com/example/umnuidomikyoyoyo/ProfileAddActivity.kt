package com.example.umnuidomikyoyoyo

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ProfileAddActivity : AppCompatActivity() {

    private lateinit var faceProfileImageView: ImageView
    private lateinit var leftbutton2: ImageView
    private val pickImage = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            val uri: Uri? = data?.data
            faceProfileImageView.setImageURI(uri)
        }
    }

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                // Разрешение предоставлено. Продолжайте работу.
            } else {
                // Разрешение не предоставлено. Обработайте это.
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        faceProfileImageView = findViewById(R.id.faceprofile)
        leftbutton2 = findViewById(R.id.leftbutton2)

        faceProfileImageView.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {

            }
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickImage.launch(intent)
        }

        leftbutton2.setOnClickListener {
            val intent = Intent(this, MainPage::class.java) // Замените на имя вашей активити
            startActivity(intent)
        }
    }
}
