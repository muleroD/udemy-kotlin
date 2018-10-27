package com.mulero.udemyk06addactivity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Indo para a segunda tela
    fun changeActivity(view: View){

        //1. Contexto; 2.Para onde eu vou
        val intent = Intent(applicationContext, Main2Activity::class.java)

        //Coletando o nome do usuario e armazenando na key input
        intent.putExtra("input", editText.text.toString())

        startActivity(intent)
    }
}
