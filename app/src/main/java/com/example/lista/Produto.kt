package com.example.lista

import android.graphics.Bitmap

class Produto(
        val nome: String,
        val quantidade: Int,
        val valor: Double,
        val imagem: Bitmap? = null
) {
}