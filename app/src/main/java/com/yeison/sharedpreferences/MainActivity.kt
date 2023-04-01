package com.yeison.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    var campoUser:EditText?=null
    var campoPass:EditText?=null
    var textUser:TextView?=null
    var textPass:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val miBotonOtraPantalla: Button= findViewById(R.id.button_CargarPantalla)
        miBotonOtraPantalla.setOnClickListener { onClick() }

        iniciarComponentes()
    }

    private  fun onClick(){
        val intent = Intent(this, MostrarResultados::class.java)

        val bundleUser: Bundle=Bundle()
        bundleUser.putString("User",campoUser!!.text.toString())
        intent.putExtras(bundleUser)

        val bundlePass: Bundle= Bundle()
        bundlePass.putString("Pass", campoPass!!.text.toString())
        intent.putExtras(bundlePass)

        startActivity(intent)
    }

    private fun iniciarComponentes() {
        var buttonGuardar:Button=findViewById(R.id.button_Guardar)
        buttonGuardar.setOnClickListener{guardarDatos()}

        var buttonCargarDatos:Button=findViewById(R.id.button_CargarDatos)
        buttonCargarDatos.setOnClickListener { cargarDatos() }

        campoUser=findViewById(R.id.input_User)
        campoPass=findViewById(R.id.input_password)
        textUser=findViewById(R.id.space_name)
        textPass=findViewById(R.id.space_password)
    }

    private fun guardarDatos() {
        var preferences:SharedPreferences=getSharedPreferences("credenciales", Context.MODE_PRIVATE)

        var user = campoUser?.text.toString()
        var pass = campoPass?.text.toString()

        var editor:SharedPreferences.Editor=preferences.edit()
        editor.putString("user",user)
        editor.putString("pass",pass)

        textUser?.text=user
        textPass?.text=pass

        editor.commit()

        Toast.makeText(this,"Se registran los datos",Toast.LENGTH_SHORT).show()

    }


    private fun cargarDatos() {
        var preferences:SharedPreferences=getSharedPreferences("credenciales",Context.MODE_PRIVATE)
        var user: String? = preferences.getString("user","No existe la informacion")
        var pass: String? = preferences.getString("pass","No existe la informacion")

        textUser?.text=user
        textPass?.text=pass
    }


}