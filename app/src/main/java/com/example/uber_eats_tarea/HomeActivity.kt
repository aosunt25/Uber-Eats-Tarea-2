package com.example.uber_eats_tarea

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.view.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        textView.text = "3"

        Handler().postDelayed({
            textView.text = "2"
        }, 2000)

        Handler().postDelayed({
            textView.text = "1"
        }, 3000)

        Handler().postDelayed({
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)
            finish()
        }, 4000)
    }

}