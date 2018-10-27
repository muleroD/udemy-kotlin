package com.mulero.udemyk11listviews

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //ListView - Lista com interação que abre uma nova tela exibindo elas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Criando os arrayList dos nomes, imagens e locais
        var landmarkNames = ArrayList<String>()
        val landmarkImages = ArrayList<Bitmap>()
        val landmarkLocation = ArrayList<String>()

        //Criando o arrayList do tipo Bitmap para armazenar as imagens
        val pisa = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.pisa)
        val colosseum = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.colosseum)
        val eiffel = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.eiffelTower)
        val bigben = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.bigben)
        val alexan = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.AlexBibliotheca)


        //Adicionado itens em cada landmark especifico
        landmarkNames.add("Tower of Pisa")
        landmarkNames.add("Colosseum")
        landmarkNames.add("Eiffel Tower")
        landmarkNames.add("Big Ben")
        landmarkNames.add("Bibliotheca Alexandrina")

        landmarkImages.add(pisa)
        landmarkImages.add(colosseum)
        landmarkImages.add(eiffel)
        landmarkImages.add(bigben)
        landmarkImages.add(alexan)


        landmarkLocation.add("Pisa, Italy")
        landmarkLocation.add("Rome, Italy")
        landmarkLocation.add("Paris, France")
        landmarkLocation.add("London, England")
        landmarkLocation.add("Alexandria, Egypt")


        //'this' para indicar que iremos usar a MainActivity
        //simple_list_item_1 indica que tipo de listView iremos usar
        //landmarkNames para mostrar quais valores irão conter no arrayAdapter
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkNames)

        //Sincronizando arrayList com o arrayAdptado
        listView.adapter = arrayAdapter

        //Quando um item da lista for clicado
        //'i' indicando o index do item clicado
        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(applicationContext, DetailActivity::class.java)
            intent.putExtra("name", landmarkNames[i])
            intent.putExtra("image", landmarkImages[i])
            intent.putExtra("location", landmarkLocation[i])


            //enviando imagem escolhida para a variavel global que sera retornada no DetailActivity
            val bitmap = landmarkImages[i]
            val escolha = Globals.Escolha

            escolha.imagemEscolhida = bitmap

            startActivity(intent)
        }
    }
}
