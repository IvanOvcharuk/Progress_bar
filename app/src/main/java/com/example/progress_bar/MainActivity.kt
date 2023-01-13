package com.example.progress_bar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var sortowanie: Button
    private lateinit var ilerazy: EditText
    private lateinit var ileelementow: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sortowanie = findViewById(R.id.button)
        ilerazy = findViewById(R.id.ilerazy)
        ileelementow = findViewById(R.id.ileelentow)
        var progressBar = findViewById<ProgressBar>(R.id.progressBar)
        var progress = 0

        fun losowanie(size: Int): MutableList<Int> {
            val random = Random()
            return List(size) { random.nextInt(1000) }.toMutableList()

        }

       sortowanie.setOnClickListener {
           progress = 0
           progressBar.setProgress(progress)
           progressBar.setMax(ilerazy.text.toString().toInt())
           if (ilerazy.text.isNotEmpty() && ileelementow.text.isNotEmpty()) {
               val losowa_lista = losowanie(ileelementow.text.toString().toInt())
               for (i in 0..ilerazy.text.toString().toInt()){
                   babelkowe(losowa_lista)
                    progress += 1
               progressBar.setProgress(progress)}
               findViewById<TextView>(R.id.textView).text = losowa_lista.toString()
           }
       }

        }
    }
fun babelkowe(tab: MutableList<Int>) {
    for (i in 0 until (tab.size - 1)) {
        for (j in 0 until (tab.size - i - 1)) {
            if (tab[j] > tab[j + 1]) {
                val tmp = tab[j]
                tab[j] = tab[j + 1]
                tab[j + 1] = tmp
            }
        }
    }
}
