package com.example.a6haftadersnotlari

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.a6haftadersnotlari.databinding.ActivityMainBinding
import java.util.RandomAccess
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var score =0
    var imageList=ArrayList<ImageView>()//resimlerin hepsi bu listeye eklenir
    var runnable= Runnable {  }//burdadaki iki fonksiyon zamana bağlı çalışmayı sağlayacak
    var handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        imageList.add(binding.top1)
        imageList.add(binding.top2)
        imageList.add(binding.top3)
        imageList.add(binding.top4)
        imageList.add(binding.top5)
        imageList.add(binding.top6)
        imageList.add(binding.top7)
        imageList.add(binding.top8)
        imageList.add(binding.top9)
        gizle()
        object : CountDownTimer(15000,1000){
            override fun onTick(millisUntilFinished: Long) {
                binding.zaman.text="Zaman: ${millisUntilFinished/1000}"
            }

            override fun onFinish() {
                binding.zaman.text=" Süreniz Bitti "
                handler.removeCallbacks(runnable)
                for (image in imageList){
                    image.visibility=View.INVISIBLE //listeye eklenen tüm elemanlar gizlendi(Gone dersek tamamen silinir)
                }
                var alert= AlertDialog.Builder(this@MainActivity)//uygulamanın ortasında bir uyarı vermek içim
                alert.setTitle("Oyun Bitti")
                alert.setMessage("Yeniden Başlamak İster Misin?")
                alert.setPositiveButton("Evet",DialogInterface.OnClickListener { dialogInterface, i ->
                    //bu kısıma yazılan işlem gerçekleştirilecek
                    var main1=intent
                    finish()
                    startActivity(main1)
                })
                alert.setNegativeButton("Hayır",DialogInterface.OnClickListener{dialogInterface,i->
                    Toast.makeText(this@MainActivity,"Oyun Bitti",Toast.LENGTH_SHORT).show()

                })
                alert.show()
            }

        }.start()
        }
    fun gizle(){//bir liste tanımlıyoruz önce ve elemanları geziyoruz
        runnable = object : Runnable {//gecikmeli olarak çalıştırılacak aktiviteler
            override fun run() {
            for (image in imageList){
                image.visibility=View.INVISIBLE //listeye eklenen tüm elemanlar gizlendi(Gone dersek tamamen silinir)
            }
            var randomindex=Random.nextInt(9)
            imageList[randomindex].visibility=View.VISIBLE
            handler.postDelayed(runnable,1000)//belirli zamana göre yer değiştiriliyor
            }
        }
       handler.post(runnable)
    }

    fun skorartir(view:View){//buradaki view nesnelere bağlayacağımızı gösterir bunun için kullanılır
        score+=1
        binding.skor.text= "SKOR : $score"  //skor değişkenindeki yazıyı değiştiriyoruz
       // gizle()//skor artırma işlemi sonrasında top simgesini gizliyoruz

    }
    }

