package com.example.lista

import android.app.Activity
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.list_view_item.*

class CadastroActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        Button_Inserir_cadastro.setOnClickListener {
            val produtos = Edit_Nome.text.toString()
            val quantidade = Edit_Quantidade.text.toString()
            val valor = Edit_Preco.text.toString()


            if(produtos.isNotEmpty() && quantidade.isNotEmpty() && valor.isNotEmpty()){
                val cadastroProduto = Produto(produtos,quantidade.toInt(), valor.toDouble())
                produtosGlobal.add(cadastroProduto)

                Edit_Nome.text.clear()
                Edit_Quantidade.text.clear()
                Edit_Preco.text.clear()
            }else{
                if(produtos.isNotEmpty()){
                    Edit_Nome.error = "Preencha o nome do Produto"
                }else{
                    Edit_Nome.error = null
                }
                if(quantidade.isNotEmpty()){
                    Edit_Quantidade.error = "Preencha a quantidade"
                }else{
                    Edit_Quantidade.error = null
                }
                if(valor.isNotEmpty()){
                    Edit_Preco.error = "Preencha o valor"
                }else{
                    Edit_Preco.error = null
                }

            }

        }

    }

}