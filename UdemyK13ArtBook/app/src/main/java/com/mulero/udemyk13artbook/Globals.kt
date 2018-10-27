package com.mulero.udemyk13artbook
import android.graphics.Bitmap

class Globals {

    companion object Escolha{
        var imagemEscolhida : Bitmap? = null
        fun retornarImagem():Bitmap{
            return imagemEscolhida!!
        }
    }
}