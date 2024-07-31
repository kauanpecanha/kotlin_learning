package org.example

import com.google.gson.annotations.SerializedName

// DIFERENÇA ENTRE VAR E VAL
/*
* var: variáveis que permitem posterior mudança de valores
* val: variáveis que NÃO permitem posterior mudança de valores
*
* */

class Jogo(
        @SerializedName("title") val titulo:String,
        @SerializedName("thumb") val capa:String
    ) {
    val descricao: String = ""

    override fun toString(): String {
        return "Jogo(titulo='$titulo', capa='$capa', descricao='$descricao')"
    }


}