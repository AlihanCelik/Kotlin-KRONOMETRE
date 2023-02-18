package com.example.kronometre

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var runnable =Runnable{ }
    var handler=Handler(Looper.myLooper()!!)
    var numara=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,"Hoşgeldiniz",Toast.LENGTH_LONG).show()

    }
    fun baslat(view: View){

        numara =0
        runnable=object: Runnable{
            override fun run() {
                numara =numara+1
                textView.text="Sayaç: ${numara}"
                handler.postDelayed(runnable,1000)
            }

        }
        handler.post(runnable)
    }
    fun durdur(view: View){

        val uyarimesaji=AlertDialog.Builder(this@MainActivity)
        uyarimesaji.setTitle("Kronometre durdu...")
        uyarimesaji.setMessage("Uygulamada Kalmak İstiyor musunuz?")
        uyarimesaji.setPositiveButton("Evet",DialogInterface.OnClickListener{ dialogInterface, i ->
            Toast.makeText(this,"Uygulamadasınız...",Toast.LENGTH_LONG).show()

        })
        uyarimesaji.setNegativeButton("Hayır",DialogInterface.OnClickListener { dialogInterface, i ->
            Toast.makeText(this,"Uygulmadan çıktınız...",Toast.LENGTH_LONG).show()
            finish()
        })
        uyarimesaji.show()
        handler.removeCallbacks(runnable)
        numara=0
        textView.text="Sayaç: ${numara}"



    }

}