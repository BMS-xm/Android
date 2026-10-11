package com.example.studying

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.button).setOnClickListener {
            val mes = findViewById<TextInputEditText>(R.id.Edit).text.toString()
            val explicit = Intent(this, Activity2::class.java).apply {
                putExtras(Bundle().apply { putString("message", mes) })
            }
            startActivity(explicit)
        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            val mes = findViewById<TextInputEditText>(R.id.Edit).text.toString()
            val share = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_TEXT,mes)
                type = "text/plain"
            }
            startActivity(share)
        }
    }
}