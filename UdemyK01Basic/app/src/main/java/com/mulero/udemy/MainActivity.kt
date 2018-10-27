package com.mulero.udemy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/* - - - Exibindo informações no console / VAR / VAL - - - */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declarando constantes (VAL)
        //Constantes são imutaveis ou seja, seu valor não pode ser alterado
        val x = 5
        val y = 4
        //x = 6 ERROR
        /* Essa parte obtivemos um erro já que não conseguimos mudar um 'val'*/

        //Para isso criamos uma variavel (VAR)
        var z = 6
        z = 5
        //Assim não temos nenhum erro

        //Criamos contanstes quando não queremos que o valor seja alterado
        val pi = 3.14159
        //E usamos variaveis quando os valores podem ser variados
        var raio = 3
        raio = 4
        raio = 8


        //Exibindo valores no console INT
        println(x)
        println(y)
        val age = 20
        val result = age * 5 / 4
        println(result)


        //Double/Float
        val newAge = 20.0
        val newResult = newAge * 5 / 4
        println(newResult)

        //Dessa forma conseguimos ver os valores decimais


        //Strings
        val name = "Richard"
        println(name)
        val surname = "Mulero"

        val nomeCompleto = name + " " + surname //concatenando
        println(nomeCompleto)


        //Boolean
        var isAlive = true
        isAlive = false

        if(isAlive == true)
            println("Gloria a Deux")
        else
            println("Trágico")


        //Caso eu queira especificar qual o tipo da minha variavel/constante será necessario o :
        val myInteger : Int = 5
        var myDouble : Double = 1.4159
        val myName : String = "Slim Shade"


        //Arrays -------------------------------
        //Especifque o tipo do array dentro das '<>'
        //Quantidade de elementos dentro dos '(size ...)'
        //Esse é o menos pratico porque precisamos especificar o tamanho como por exemplo
        val myArray = arrayOfNulls<String>(size = 4)

        myArray[0] = "Primeiro Elemento"
        myArray[1] = "Segundo Elemento"
        myArray[2] = "Terceiro Elemento"
        myArray[3] = "Ultimo Elemento"

        println(myArray[2])

        //Sem especificar o tamanho do array
        val myNumberArray = intArrayOf(10, 20, 30, 40, 50)
        println("Tamanho do array: " + myNumberArray.size)

        //Alterar elemento do array(index, novoValor)
        myNumberArray.set(2, 25)
        println(myNumberArray[2])


        //ArrayList (um array sem limites, sem definir tamanho)

                                //tipo do array
        val myMusician = ArrayList<String>()

        myMusician.add("James")
        myMusician.add("Lars")

        println(myMusician) //[James, Lars]

        //adicionando um elemento em um index especificio
        myMusician.add(1,"Kirk")
        println(myMusician) //[James, Kirk, Lars]

        //Muito mais flexiveis, usaremos com frequencia


        //Sets - Conjuntos (Python)
        val mySet = HashSet<String>()

        mySet.add("Kirk")
        mySet.add("Kirk")

        println(mySet.size) //1

        //Sets não contem valores duplicados, semelhantes ao Python
        /*A Set is an unordered collection data type that is iterable, mutable, and has no duplicate elements.*/


        //Map - Dictionary (Python)
        //Parecidos com matrizes

                                //Key, Value
        val myHashMap = HashMap<String, String>()

        //1º parametro eu especifico onde irei armazenar o valor
        myHashMap.put("name" , "James")
        myHashMap.put("instrument" , "Guitar")

        println(myHashMap["instrument"]) // Guitar
        println(myHashMap["name"]) // James


        //If Statemantes
        var m = 5
        var n = 4

        if(m > n){
            println("m is greater than n")
        }else {
            println("m isn't greater than n")
        }


        //Switch
        val day = 4
        var dayString = ""

        when(day){
            1 -> dayString = "Monday"
            2 -> dayString = "Tuesday"
            3 -> dayString = "Wednesday"
            else -> dayString = "?????"
        }

        println(dayString)


        //For Loop
        val myNumber = intArrayOf(12, 15, 18,  21, 24)

        for(number in myNumber){
            val z  = number / 3 * 5
            println(z)
        }

        for(i in myNumber.indices){
            val y = myNumber[i]
            println(y)
        }

        //i = 0; i <=9; i++
        for(a in 0..9){
            val b = a * 10
            println(b)
        }
        //----------------

        //While Loop
        var j = 0

        while(j <= 10){
            val x = j * 10
            println(x)
            j++
        }

    }
}
