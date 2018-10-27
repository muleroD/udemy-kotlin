package com.mulero.udemyk09dialogalert

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun save(view: View){

        //Parecido com o JOptionPane do java, o AlertDialog exibe um alerta com opções

        val alert = AlertDialog.Builder(this)

        //Titulo do alerta
        alert.setTitle("Salvar")

        //Mensagem exibida dentro do alerta
        alert.setMessage("Você deseja salvar tudo?")

        //Caso o usuário escolha a opção "SIM" será exibido um Toast com tempo longo exibindo a mensagem "SALVO"
        alert.setPositiveButton("Sim"){
                dialogInterface: DialogInterface, i: Int -> Toast.makeText(applicationContext, "Salvo!", Toast.LENGTH_LONG).show()
        }

        //Caso o usuário escolha a opção "NÃO" será exibido um Toast com tempo cursto exibindo a mensagem "Cancelado"
        alert.setNegativeButton("Não"){
            dialogInterface: DialogInterface, i: Int -> Toast.makeText(applicationContext, "Cancelado", Toast.LENGTH_SHORT).show()
        }

        //Exibe o alerta
        alert.show()
    }

}
