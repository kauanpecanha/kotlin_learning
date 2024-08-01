
package org.example

// operações com listas

fun main() {

    // lista imutável
    val listNamesImutable:List<String> = listOf("Kauan", "Peçanha", "Lira")

    // lista mutável
    var listNamesMutable:List<String> = mutableListOf("Kauan", "Peçanha", "Lira")

    // first: palavra de acesso ao primeiro item da lista
    val primeiroNome:String = listNamesMutable.first()

    // last: palavra de acesso ao último item da lista
    val ultimoNome:String = listNamesMutable.last()

    // expressão lógica de pertencimento de uma lista
    val estaPresente: Boolean = (primeiroNome in listNamesImutable)

    // operação de adição de um item a uma lista
    listNamesMutable += "novaAdicao"

    listNamesMutable -= "Lira"

    println(listNamesMutable)
}