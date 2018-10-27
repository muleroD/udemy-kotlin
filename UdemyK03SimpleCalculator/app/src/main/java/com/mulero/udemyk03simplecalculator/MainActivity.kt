package com.mulero.udemyk03simplecalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun somar(view: View){

        val n1 = Integer.parseInt(number1.text.toString())
        val n2 = Integer.parseInt(number2.text.toString())

        val result = n1 + n2

        //Usando o $ seria da mesma forma que se concatenasse a string com a variavel resultado
        textView.text = "Result: $result"
    }

    fun subtrair(view: View){

        val n1 = Integer.parseInt(number1.text.toString())
        val n2 = Integer.parseInt(number2.text.toString())

        val result = n1 - n2

        textView.text = "Result: $result"
    }

    fun multiplcar(view: View){

        val n1 = Integer.parseInt(number1.text.toString())
        val n2 = Integer.parseInt(number2.text.toString())

        val result = n1 * n2

        textView.text = "Result: $result"
    }

    fun dividir(view: View){

        val n1 = Integer.parseInt(number1.text.toString())
        val n2 = Integer.parseInt(number2.text.toString())

        val result = n1 / n2

        textView.text = "Result: $result"
    }
}
