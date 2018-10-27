package com.mulero.udemyk12database

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Tratando possiveis erros de SQL
        try {

            //Criando banco de dados
            val myDataBase = this.openOrCreateDatabase("Musicos", Context.MODE_PRIVATE, null)

            //Criando tabela 'Musicos' caso ela não exista
            myDataBase.execSQL("CREATE TABLE IF NOT EXISTS musicos(nome VARCHAR, idade INT(2), instrumentos VARCHAR)")

            //Inserindo dados na tabela 'musicos'
            myDataBase.execSQL("INSERT INTO musicos (nome, idade, instrumentos) VALUES ('James Hetfield', 55, 'Vocal, Guitarra, Baixo e Bateria')")
            myDataBase.execSQL("INSERT INTO musicos (nome, idade, instrumentos) VALUES ('Kirk Hammett', 55, 'Guitarra, Baixo e Sitar')")
            myDataBase.execSQL("INSERT INTO musicos (nome, idade, instrumentos) VALUES ('Lars Ulrich', 55, 'Bateria e Percussão')")

            //Atualizando dado
            myDataBase.execSQL("UPDATE musicos SET idade = 54 WHERE nome = 'Lars Ulrich'")

            //Apagando dado
            myDataBase.execSQL("DELETE FROM musicos WHERE nome = 'James Hetfield'")

            //recuperando todos os dados
            val conexao = myDataBase.rawQuery("SELECT * FROM musicos", null)

            //recuperando dados com filtro de idade
            val conexaoFiltrada = myDataBase.rawQuery("SELECT * FROM musicos WHERE idade = 55", null)

            //Armazenando index de cada coluna
            val indexNome = conexao.getColumnIndex("nome")
            val indexIdade = conexao.getColumnIndex("idade")
            val indexInstru = conexao.getColumnIndex("instrumentos")

            //coloca o conexao na primeira linha de registros
            conexao.moveToFirst()

            //Exibe os dados de cada linha
            while(conexao != null){
                println("Nome: " + conexao.getString(indexNome))
                println("Idade: " + conexao.getInt(indexIdade))
                println("instrumentos: " + conexao.getString(indexInstru))
                println("\n")

                conexao.moveToNext()
            }

            //Fechando conexão e assegurando que os valores não serão 'null'
            if(conexao!= null){
                conexao!!.close()
            }


        } catch(e: Exception){
            //Imprimindo a causa do erro
            e.printStackTrace()
        }

    }
}
