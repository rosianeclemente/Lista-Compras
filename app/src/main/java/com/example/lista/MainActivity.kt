package com.example.lista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Implementação do Adaptador
        val produtosAdapter = ProdutoAdapter(this)
        //Definindo o adaptador na lista
        List_item.adapter = produtosAdapter


        //ira excluir item com click longo
        List_item.setOnItemLongClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long->

            //buscando o item na lista
            val item = produtosAdapter.getItem(position)
            //removendo o item clicando na lista
            produtosAdapter.remove(item)
            true
          }
        Button_Adicionar.setOnClickListener {
            //Criando a Intent explicita
            val intent = Intent(this, CadastroActivity::class.java)

            //iniciando a atividade
            startActivity(intent)
        }

       }

    override fun onResume() {
        super.onResume()
        val adapter = List_item.adapter as ProdutoAdapter
        adapter.clear()
        adapter.addAll(produtosGlobal)
        val soma = produtosGlobal.sumByDouble { it.valor * it.quantidade }
        val formatValor = NumberFormat.getCurrencyInstance(Locale("pt","br"))
        Valor_Total.text = "TOTAL:  ${formatValor.format(soma)}"
    }

    }

