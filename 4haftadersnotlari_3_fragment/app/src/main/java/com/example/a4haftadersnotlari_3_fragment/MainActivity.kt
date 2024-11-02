package com.example.a4haftadersnotlari_3_fragment

import android.os.Bundle
import android.widget.Button
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
        var buton1=findViewById<Button>(R.id.button)
        var buton2=findViewById<Button>(R.id.button2)
        buton1.setOnClickListener {
            var degis=supportFragmentManager.beginTransaction()
            degis.replace(R.id.fragmentContainerView2,bir())
            degis.commit()
        }
        buton2.setOnClickListener {
            var degis=supportFragmentManager.beginTransaction()
            degis.replace(R.id.fragmentContainerView2,iki())
            degis.commit()
        }
    }
}