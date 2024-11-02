package com.example.a4haftadersnotlari

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class aktivite_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_aktivite2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val extras=intent.extras?:return //veri gelip gelmediğini kontrol ediyoruz gelmemişse çalıştırma
        var isim= extras.getString("isim")
        var numara=extras.getString("numara")
        var yazi=findViewById<TextView>(R.id.hosgeldiniz)
        yazi.text="Hoşgeldiniz : " + isim + "\n" + numara

        var buton2 =findViewById<Button>(R.id.button_2)
        buton2.setOnClickListener {
            var intent=Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }
}