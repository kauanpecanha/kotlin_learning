package org.example

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
    val descricao: String = ""

    override fun toString(): String {
        return "Jogo(titulo='$titulo', capa='$capa', descricao='$descricao')"
    }


}