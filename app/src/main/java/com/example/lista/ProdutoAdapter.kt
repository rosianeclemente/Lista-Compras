package com.example.lista

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.security.AccessControlContext
import java.text.FieldPosition
import java.text.NumberFormat
import java.util.*
import kotlin.coroutines.coroutineContext

@Suppress("UNREACHABLE_CODE")
class ProdutoAdapter(context: Context) : ArrayAdapter<Produto>(context, 0){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutView :View
        if(convertView != null){
            layoutView = convertView
        }else {
            layoutView = LayoutInflater.from(context).inflate(R.layout.list_view_item, parent, false)
        }
        val item = getItem(position)

        val nomeDoProduto = layoutView.findViewById<TextView>(R.id.Nome_produto)
        val quantidadeDeProduto = layoutView.findViewById<TextView>(R.id.Quantidade)
        val valorDoProduto = layoutView.findViewById<TextView>(R.id.Valor)
        val imagemDoProduto = layoutView.findViewById<ImageView>(R.id.Imagem)

        quantidadeDeProduto.text = item?.nome
        nomeDoProduto.text = item?.quantidade.toString()
        valorDoProduto.text = item?.valor.toString()

        if (item?.imagem!= null){
            imagemDoProduto.setImageBitmap(item.imagem)
        }
        return layoutView
        //obtendo a instancia do objeto de formatação
        val formatar = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
        //formatando a variavel no formato moeda
        valorDoProduto.text = formatar.format(item?.valor)
    }



}


