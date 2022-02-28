package com.dani96.myapplication1

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.dani96.analizadores.lexico.DocFLex
import com.dani96.analizadores.sintactico.DocCup
import com.example.myapplication1.R
import java.io.StringReader

class MainActivity : AppCompatActivity() {

    var boton : Button? = null
    var textInsert: EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init();
    }
    fun init(){
        setFronted();
       // analizarEntrada();
    }
    fun setFronted(){
        boton = findViewById<Button>(R.id.botonEjecutar);
        textInsert= findViewById<EditText>(R.id.editTextTextPersonName)
        boton?.setOnClickListener{analizarEntrada(((textInsert))?.getText().toString())}
    }
    fun analizarEntrada(h:String){
        println("PASE "+ h)
        //val txt= findViewById<TextView>(R.id.textF2)
        //txt.text= h
        AlertDialog.Builder(this).apply {
            setTitle("TEXTO INGRESADO: ")
            setMessage(h)
            setPositiveButton("Aceptar"){_: DialogInterface, _: Int ->

            }.show()
        }

        var mensaje = h
        var e = StringReader(mensaje);
        var lex = DocFLex(e);
        var par = DocCup(lex);
        try {
            par.parse();
        }catch (h: Exception){
            println("error en el try catch ")
        }

    }



}