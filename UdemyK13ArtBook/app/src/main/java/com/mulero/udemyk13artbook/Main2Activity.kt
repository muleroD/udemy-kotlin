package com.mulero.udemyk13artbook

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*
import java.io.ByteArrayOutputStream

class Main2Activity : AppCompatActivity() {

    var imagemSelecionada: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        //Verificando se a imagem seleciona é mesmo uma nova imagem
        val intetn = intent
        val info = intent.getStringExtra("info")

        if(info.equals("novo")){
            val background = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.select)
            imageView.visibility  = View.VISIBLE
            editText.setText("")
            //editText... podemos deixar o campo de texto bloqueado
        } else{
            //Se não for uma nova imagem, exibe os dados necessarios (titulo e a imagem)
            val titulo = intent.getStringExtra("titulo")
            editText.setText(titulo)

            val escolha = Globals.Escolha
            val bitmap = escolha.imagemEscolhida

            imageView.setImageBitmap(bitmap)
            button.visibility = View.INVISIBLE
        }
    }

    fun selecionarPintura(view: View){

        //Se eu não tiver permissão para ler os arquivos externos.
        if(checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            //Pedindo novamente permissão
            requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 2)
        } else {
            //Abrindo a opção de selecionar uma imagem do armazenamento do usuário
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 1)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        //Se a permissão foi 2 (READ_EXTERNAL_STORAGE)

        if(requestCode == 2){                   //Verificando se a permissão foi mesmo liberada
            if(grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, 1)
            }
        }


        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        //Verificando se ele selecionou alguma imagem
        if(requestCode == 1 && resultCode == Activity.RESULT_OK && data != null){

            val imagem = data.data

            //Previnindo possiveis erros
            try{
                imagemSelecionada = MediaStore.Images.Media.getBitmap(this.contentResolver, imagem)
                imageView.setImageBitmap(imagemSelecionada)
            } catch (e: Exception){
                e.printStackTrace()
            }
        }

        super.onActivityResult(requestCode, resultCode, data)
    }


    fun salvarPintura(view: View){

        val titulo =editText.text.toString()

        //Convertendo imagem em um array de bytes
        val saida = ByteArrayOutputStream()
        imagemSelecionada?.compress(Bitmap.CompressFormat.PNG, 50, saida)
        val byteArray = saida.toByteArray()

        try{

            val dataBase = this.openOrCreateDatabase("Artes", Context.MODE_PRIVATE, null)
            dataBase.execSQL("CREATE TABLE IF NOT EXISTS artes (nome VARCHAR, imagem BLOB)")

            val sqlStringInsert = "INSERT INTO artes (nome, imagem) VALUES (?, ?)"
            val statemant = dataBase.compileStatement(sqlStringInsert)

            statemant.bindString(1, titulo)
            statemant.bindBlob(2, byteArray)
            statemant.execute()

        }catch(e: Exception){
            e.printStackTrace()
        }

        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)

    }

}
