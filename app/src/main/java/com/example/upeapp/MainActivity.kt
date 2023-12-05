package com.example.upeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1: Button = findViewById(R.id.button2)
        val Username_view: EditText = findViewById(R.id.Username)
        val Password_view: EditText = findViewById(R.id.Password)
        val switch_adm: Switch = findViewById(R.id.switch1)
        val btn_criar_conta: Button = findViewById(R.id.btnCriarConta)
        val btn_recuperar_senha: Button = findViewById(R.id.Recuperarsenha)
        val Useradm: EditText = findViewById(R.id.chaveadm)
        val criar_conta: Button = findViewById(R.id.btnCriarConta)
        val recuperar_senha: Button = findViewById(R.id.Recuperarsenha)

        //botão criar conta
        criar_conta.setOnClickListener(){
            val e = Intent(this,Criarcontapag::class.java)
            startActivity(e)
        }
        //botão recuperar senha
        recuperar_senha.setOnClickListener(){
            val w = Intent(this,Recuperarsenhapag::class.java)
            startActivity(w)
        }



        //switch de administrador
        switch_adm.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                Username_view.visibility = EditText.GONE
                Password_view.visibility = EditText.GONE
                btn_criar_conta.visibility = Button.GONE
                btn_recuperar_senha.visibility = Button.GONE
                Useradm.visibility = EditText.VISIBLE


            }else{
                Username_view.visibility = EditText.VISIBLE
                Password_view.visibility = EditText.VISIBLE
                btn_criar_conta.visibility = Button.VISIBLE
                btn_recuperar_senha.visibility = Button.VISIBLE
                Useradm.visibility = EditText.GONE

            }
        }

        // botão de login
        btn1.setOnClickListener {
            val username = Username_view.text.toString()
            val password = Password_view.text.toString()
            if(validacao(username,password)){
                val i = Intent(this, paginacentral::class.java)
                startActivity(i)
            }

        }

    }
    fun validacao(username: String,password: String): Boolean{
        return username.isNotEmpty() && password.isNotEmpty()
    }

}