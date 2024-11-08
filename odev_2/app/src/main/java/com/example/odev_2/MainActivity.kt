package com.example.odev_2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
data class Yemek(
    val ana_yemek: String,
    val ekstra_secimler: List<String>,
    val icecek: String
)
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
        val yemek_secimi = findViewById<RadioGroup>(R.id.yemek_secimi)
        val salata_box = findViewById<CheckBox>(R.id.salata_box)
        val corba_box = findViewById<CheckBox>(R.id.corba_box)
        val patates_box = findViewById<CheckBox>(R.id.patates_box)
        val tatli_box = findViewById<CheckBox>(R.id.tatli_box)
        val icecek_secimi = findViewById<RadioGroup>(R.id.icecek_secimi)
        val buton = findViewById<Button>(R.id.button)

        buton.setOnClickListener {
            val yemek_secimi = yemek_secimi.checkedRadioButtonId
            val icecek_secimi = icecek_secimi.checkedRadioButtonId

            val ana_yemek = findViewById<RadioButton>(yemek_secimi).text.toString()
            val icecek = findViewById<RadioButton>(icecek_secimi).text.toString()

            val ekstra_secimler = mutableListOf<String>()
            if (salata_box.isChecked) ekstra_secimler.add("Salata")
            if (patates_box.isChecked) ekstra_secimler.add("Patates Kızartması")
            if (tatli_box.isChecked) ekstra_secimler.add("Tatlı")
            if (corba_box.isChecked) ekstra_secimler.add("Çorba")

            val yemek = Yemek(ana_yemek, ekstra_secimler, icecek)
            Toast.makeText(applicationContext, "Seçiminiz Kaydedildi", Toast.LENGTH_LONG).show()
        }
    }
}