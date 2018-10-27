package com.mulero.udemyk11listviews

import android.graphics.Bitmap

//Criamos uma classe global para utilizarmos em multiplas 'activitys'

class Globals {


    //Dentro desse objeto companheiro eu consigo "compartilhar" a variavel com a img escolhida
    companion object Escolha{
        var imagemEscolhida : Bitmap? = null
        fun retornaImagem():Bitmap{
            //'!!' significa que temos certeza de temos escolhido uma imagem
            return imagemEscolhida!!
        }
    }

}