package com.example.a4haftadersnotlari

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var buton = findViewById<Button>(R.id.button_1)
        buton.setOnClickListener {
            var intent = Intent(applicationContext,aktivite_2::class.java)//applicationcontext yerine this de yazılabilir
            var isim=findViewById<EditText>(R.id.yazi_giris)
            //ilk sayfadaki veriyi ikinci sayfaya göndermek
            intent.putExtra("isim",isim.text.toString())//isim anahtarı ile veriyi gönderiyoruz
            intent.putExtra("numara","kullanıcı numaranız : 23")
            startActivity(intent)
        }
    }
}