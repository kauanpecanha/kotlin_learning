package br.com.alura.alugames.principal

import br.com.alura.alugames.servicos.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val jogoApi = consumo.buscaJogo("151")

    println(listaGamers)
    println(jogoApi)
}