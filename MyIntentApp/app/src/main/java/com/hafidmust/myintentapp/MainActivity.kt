package com.hafidmust.myintentapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tvResult : TextView
    @SuppressLint("SetTextI18n")
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null){
            val selectedValue = result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivity = findViewById<Button>(R.id.btn_move)
        val btnMoveWithDataActivity = findViewById<Button>(R.id.btn_move_with_data)
        val btnMoveWitObject = findViewById<Button>(R.id.btn_move_with_object)
        val btnMoveForResult : Button = findViewById(R.id.btn_move_for_result)
        tvResult = findViewById(R.id.tv_result)

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

        btnMoveWitObject.setOnClickListener {
            val person = Person(
                "Hafid",
                20,
                "hafid@gmail.com",
                "Banjarnegara"
            )
            val moveWithObjectIntent = Intent(this, MoveWithObjectActivity::class.java)
            moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
            startActivity(moveWithObjectIntent)
        }

        btnMoveForResult.setOnClickListener {
            val moveForResultIntent = Intent(this, MoveForResultActivity::class.java)
            resultLauncher.launch(moveForResultIntent)
        }
    }
}