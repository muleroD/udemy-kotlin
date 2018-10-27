package com.mulero.udemyk13artbook

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tituloArray = ArrayList<String>()
        val imagemArray = ArrayList<Bitmap>()

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tituloArray)
        listView.adapter = arrayAdapter

        try {

            val dataBase = this.openOrCreateDatabase("Artes", Context.MODE_PRIVATE, null)
            dataBase.execSQL("CREATE TABLE IF NOT EXISTS artes (titulo VARCHAR, imagem BLOB)")

            val cursor = dataBase.rawQuery("SELECT * FROM artes", null)

            val tituloIndex = cursor.getColumnIndex("titulo")
            val imagemIndex = cursor.getColumnIndex("imagem")

            cursor.moveToFirst()

            while (cursor != null){

                tituloArray.add(cursor.getString(tituloIndex))
                val byteArray = cursor.getBlob(imagemIndex)
                val imagem = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)

                imagemArray.add(imagem)

                cursor.moveToNext()
                arrayAdapter.notifyDataSetChanged()
            }

            cursor?.close()

        }catch(e: Exception){
            e.printStackTrace()
        }


        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(applicationContext, Main2Activity::class.java)
            intent.putExtra("titulo", tituloArray[i])
            intent.putExtra("info", "antigo")

            val escolha = Globals.Escolha
            escolha.imagemEscolhida = imagemArray[i]

            startActivity(intent)

        }

    }

    //Conectando o menu que criamos com a tela inicial
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.add_art, menu)

        return super.onCreateOptionsMenu(menu)
    }

    //Definindo o que vai acontecer quando a opção do menu for selecionada
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        //Se tiver um menu, leve para outra tela
        if(item?.itemId == R.menu.add_art){
            val intent = Intent(applicationContext, Main2Activity::class.java)
            intent.putExtra("info", "novo")
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}
