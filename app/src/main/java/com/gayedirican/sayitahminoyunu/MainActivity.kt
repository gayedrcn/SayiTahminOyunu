package com.gayedirican.sayitahminoyunu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.gayedirican.sayitahminoyunu.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val randomSayi = (1..100).random()
        var skor = 100
        binding.buttonTahminet.setOnClickListener {
            val girilenTahmin = binding.editTextTahmin.text
            val tahmintoint: Int = Integer.parseInt(girilenTahmin.toString())
            if (tahmintoint<0 || tahmintoint>100) {
                binding.textViewSayiyaYakinlik.setText("Lütfen 1-100 arasında bir sayı giriniz")
            } else if(tahmintoint < randomSayi) {
                binding.textViewSayiyaYakinlik.setText("Daha Büyük Bir Sayı Dene")
                skor -= 1
                binding.textViewSkor.setText("Skorunuz: $skor")
            } else if (tahmintoint > randomSayi) {
                binding.textViewSayiyaYakinlik.setText("Daha Küçük Bir Sayı Dene")
                skor -= 1
                binding.textViewSkor.setText("Skorunuz: $skor")
            } else if (tahmintoint == randomSayi) {
                binding.textViewSayiyaYakinlik.setText("Tebrikler Bildiniz! Skorunuz: $skor")
                binding.textViewSkor.setText("")
                binding.editTextTahmin.visibility = View.GONE
            }

        }

    }
}