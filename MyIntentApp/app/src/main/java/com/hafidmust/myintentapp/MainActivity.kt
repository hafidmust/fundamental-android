package com.hafidmust.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity = findViewById<Button>(R.id.btn_move)

        btnMoveActivity.setOnClickListener {
            val moveIntent = Intent(this, MoveActivity::class.java)
            startActivity(moveIntent)

        }
    }
}