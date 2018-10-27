package com.mulero.myfirstkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

/*Primeira Aplicação
* Uma imagem com botão, onde quando clicamos no botão a imagem muda*/

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Criando uma função que altera a imagem quando clicamos no botão
    fun change (view: View){
        imageView.setImageResource(R.drawable.throughMany)
    }
}
