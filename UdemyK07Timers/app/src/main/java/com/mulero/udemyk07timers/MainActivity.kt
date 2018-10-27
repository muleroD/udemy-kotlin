package com.mulero.udemyk07timers

import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.mulero.udemyk07timers.R.id.textView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Criando um countdown/objeto começando dos 10  segundos e diminuindo 1
        object: CountDownTimer(10000,1000){
            override fun onFinish() {
                //o que vai acontecer quando o contador acabar
                textView.text = "Left: 0"
                Toast.makeText(applicationContext,"F I N I S H", Toast.LENGTH_LONG).show() //Exibindo um pop-up longo logo apos terminar o contador
            }

            override fun onTick(p0: Long) {
                //o que acontece quando se passa um tick
                textView.text = "Left: " + p0/1000 //p0 me dá quantos seguntos até eu terminar, Dividindo por 1000 para termos segundos não mili
            }
        }.start() //inicia o contador
    }
}
