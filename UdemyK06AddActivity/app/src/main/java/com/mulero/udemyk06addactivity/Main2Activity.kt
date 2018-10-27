package com.mulero.udemyk06addactivity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //Recebendo informação de outra tela e armazenando
        val intent = intent
        val received: String = intent.getStringExtra("input")

        textView2.text = received
    }

    //Voltando para a primeira tela
    fun goBack(view: View){
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}
