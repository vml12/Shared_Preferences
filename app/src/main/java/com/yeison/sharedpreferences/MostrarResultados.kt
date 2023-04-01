package com.yeison.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MostrarResultados : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_resultados)

        cargarDatos()

        val botonSalir: Button=findViewById(R.id.buttonVolver)
        botonSalir.setOnClickListener { salir() }
    }

    private fun cargarDatos() {
        val campoMensajeUser=findViewById<TextView>(R.id.textResultName)
        val campoMensajePass=findViewById<TextView>(R.id.textResultpass)

        var bundleUser: Bundle? = this.intent.extras
        var bundlePass: Bundle? = this.intent.extras

        if(bundleUser != null){
            campoMensajeUser.text="${bundleUser.getString("User")}"
        }

        if(bundlePass != null){
            campoMensajePass.text="${bundlePass.getString("Pass")}"
        }
    }

    private fun salir(){
        finish()
    }
}