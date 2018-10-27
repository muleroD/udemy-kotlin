package com.mulero.udemyk11listviews

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = intent

        val name = intent.getStringExtra("name")
        textView.text = name

        val location = intent.getStringExtra("location")
        textView2.text = location

        //Criando objeto e guardando o valor que foi enviado do Globals
        val escolha = Globals.Escolha
        val imagemSelecionada = escolha.retornaImagem()

        imageView.setImageBitmap(imagemSelecionada)
    }
}
