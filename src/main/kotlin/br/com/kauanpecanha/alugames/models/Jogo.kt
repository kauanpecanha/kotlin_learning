package org.example.br.com.kauanpecanha.alugames.models

// DIFERENÇA ENTRE VAR E VAL
/*
* var: variáveis que permitem posterior mudança de valores
* val: variáveis que NÃO permitem posterior mudança de valores
*
* */

data class Jogo(
    val titulo:String,
    val capa:String
) {
    var descricao: String? = null

    override fun toString(): String {
        return "Jogo(titulo='$titulo', capa='$capa', descricao='$descricao')"
    }


}