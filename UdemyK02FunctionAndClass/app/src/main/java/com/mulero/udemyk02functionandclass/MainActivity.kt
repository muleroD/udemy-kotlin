package com.mulero.udemyk02functionandclass

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var age : Int? = null //Eu não sei se a variavel vai ser null ou não. Por isso usamos o ?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val op = Sum()
        println(op.sum(5,3))
        println(op.div(4,2))
    }

    //Div é uma herança para isso precisamos definir na classe
    class Sum:Div() {
        fun sum(a: Int, b:  Int): Int{
            return a + b
        }
    }

    //Quando colocamos 'open' indicamos que a classe é vista para todos
    open class Div{
        fun div(a: Int, b:  Int): Int{
            return a / b
        }
    }

    fun test(){
        val x = 5 * 4
        println(x)
    }
    fun helloWorld(view: View){
        textView.text = "Hello World"

    }

    //view: View indica que iremos usar os componentes da tela
    fun makeSimpson(view: View) {

        val name = nameText.text.toString() //Nome do campo de texto

        if (!ageText.toString().equals("")){
            val age = Integer.parseInt(ageText.text.toString()) //Idade do campo de texto
        }

        val job = jobText.text.toString() //Trabalho do campo de texto

        val simpson = Simpson(name, age, job)

        textView.text = "Name: "+ simpson.name + "\nAge: " + simpson.age + "\nJob: " + simpson.job //Exibe os valores do campo na label

    }
}
