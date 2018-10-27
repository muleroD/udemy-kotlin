package com.mulero.udemyk08runnables

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number: Int = 0
    var handler: Handler = Handler()
    var runnable : Runnable = Runnable {  }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //Semelhante ao contador(regressiva)/countdown, onde você vai fazer uma operação dentro de um intervalo de tempo
    //Só que vamos fazer um contadorUp/Cronometro. Não temos limitação para a contagem

    //Sempre que start for pressionado, o número vai se tornar 0
    //Isso tudo é como iniciamos o contador
    fun start(view: View){
        number = 0
        runnable = object : Runnable{
            override fun run() {
                textView.text = "Time: " + number
                number++
                textView.text = "Time: " + number

                //This referindo ao mesmo criado no Main
                handler.postDelayed(this,1000)
            }
        }
        handler.post(runnable)
    }

    fun reset(view: View){
        //Matando o contador
        handler.removeCallbacks(runnable)
        number = 0

        textView.text= "Time: " + number
    }
}
