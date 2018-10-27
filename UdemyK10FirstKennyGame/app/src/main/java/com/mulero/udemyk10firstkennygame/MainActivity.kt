package com.mulero.udemyk10firstkennygame

import android.content.DialogInterface
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var pontuacao: Int = 0
    var imagemArray = ArrayList<ImageView>()
    var handler: Handler = Handler() //Manipulador
    var runnable : Runnable = Runnable {  } //Cronometro


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pontuacao = 0
        imagemArray.add(0,imageView1)
        imagemArray.add(1,imageView2)
        imagemArray.add(2,imageView3)
        imagemArray.add(3,imageView4)
        imagemArray.add(4,imageView5)
        imagemArray.add(5,imageView6)
        imagemArray.add(6,imageView7)
        imagemArray.add(7,imageView8)
        imagemArray.add(8,imageView9)

        ocultarExibirImagens()

        //Criando temporizador para exibir o tempo que falta
        object : CountDownTimer(10000, 1000){
            override fun onFinish() {
                timeText.text = "Tempo Esgotado!"
                handler.removeCallbacks(runnable) //Encerrando o cronometro quando o tempo acabar

                //Ocultando novamente as imagens
                for (imagem in imagemArray){
                    imagem.visibility = View.INVISIBLE
                }


                reiniciar()
            }

            override fun onTick(t0: Long) {
                timeText.text = "Tempo: " + t0/1000
            }

        }.start()

    }

    fun ocultarExibirImagens(){

        //Iniciando o cronometro
        runnable = object : Runnable{
            override fun run() {

                //Ocultando todas as imagens
                for (imagem in imagemArray){
                    imagem.visibility = View.INVISIBLE
                }

                //Criando uma variavel random para exibir aleatoriamente uma imagem
                val random = Random()
                val index = random.nextInt(8 - 0) //Limitando do 0 até o 8
                imagemArray[index].visibility = View.VISIBLE //Exibindo a imagem

                //Tempo de executar
                handler.postDelayed(runnable,500)
            }
        }

        handler.post(runnable)
    }

    fun acrescentarPontos(view: View){
        pontuacao++
        scoreText.text = "Pontuação: $pontuacao"
    }

    fun reiniciar(){
        //Criando alerta
        val alerta = AlertDialog.Builder(this)

        alerta.setTitle("Jogar novamente?")
        alerta.setMessage("Deseja iniciar o jogo novamente?")

        alerta.setPositiveButton("Sim"){
                dialogInterface: DialogInterface, i: Int -> Toast.makeText(applicationContext, "Iniciando...", Toast.LENGTH_SHORT).show()
                MainActivity()
        }

        alerta.setNegativeButton("Não"){
            dialogInterface: DialogInterface, i: Int -> Toast.makeText(applicationContext, "Obrigado por Jogar", Toast.LENGTH_LONG).show()
        }

        alerta.show()
    }
}
