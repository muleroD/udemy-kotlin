package com.mulero.udemyk05storedata

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Uma maneira de armazenar dados simples (login e senha) sem precisar de uma base de dados
        val sharedPreferences = this.getSharedPreferences("com.mulero.udemyk05storedata", Context.MODE_PRIVATE)

        var age = 30

        //chave onde encontro o valor - valor armazenado
        sharedPreferences.edit().putInt("userAge", age).apply() //idade sendo armazenada na chave userAge

        val storeAge = sharedPreferences.getInt("userAge", 0) //Chave, Posição(talvez)
        println("idade armazenada: $storeAge") //30

        //Mesmo que o usuario feche a aplicação, seu dado continuar armazenado


        //Atualizando dado armazenado - - - - - -
        age = 31
        sharedPreferences.edit().putInt("userAge", age).apply()

        val storedAge2 = sharedPreferences.getInt("userAge", 0)
        println("Nova idade: $storedAge2")

        //Não adianta eu tentar mudar o valor da idade sendo que ela já está armazenada
        age = 15784
        println("$storedAge2") //31


        //Removendo dado armazenado - - - - - -
        sharedPreferences.edit().remove("userAge").apply()
        val storedAge3 = sharedPreferences.getInt("userAge", 0)
        println("Idade removida: $storedAge3")

    }
}
