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
        val btnMoveWithDataActivity = findViewById<Button>(R.id.btn_move_with_data)

        btnMoveActivity.setOnClickListener {
            val moveIntent = Intent(this, MoveActivity::class.java)
            startActivity(moveIntent)
        }

        btnMoveWithDataActivity.setOnClickListener {
            val moveWithData = Intent(this, MoveWithDataActivity::class.java)
            moveWithData.putExtra(MoveWithDataActivity.EXTRA_NAME, "hafid")
            moveWithData.putExtra(MoveWithDataActivity.EXTRA_AGE, 20)
            startActivity(moveWithData)
        }
    }
}