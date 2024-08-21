package br.com.kauanpecanha.alugames.models

import br.com.alura.alugames.models.Jogo

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo
    ) {

    val valor: Double = gamer.plano.calculateRent(this)

    override fun toString(): String {
        return "\n\nINFORMAÇÕES DO ALUGUEL \n\n " +
                "Nome do jogo: ${jogo.titulo} \n " +
                "Nome do alugante: ${gamer.name} \n " +
                "Durante: ${periodo.emDias} dias \n" +
                " Preço final: R$ ${valor}"
    }
}