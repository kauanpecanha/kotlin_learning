package br.com.kauanpecanha.alugames.models

import Jogo

data class Aluguel(
        val gamer: Gamer,
        val jogo: Jogo,
        val periodo: Periodo
    ) {

    val valor: Double = jogo.preco * periodo.emDias

    override fun toString(): String {
        return "\n\nINFORMAÇÕES DO ALUGUEL \n\n " +
                "Nome do jogo: ${jogo.titulo} \n " +
                "Nome do alugante: ${gamer.name} \n " +
                "Durante: ${periodo.emDias} dias \n" +
                " Preço final: R$ ${valor}"
    }
}