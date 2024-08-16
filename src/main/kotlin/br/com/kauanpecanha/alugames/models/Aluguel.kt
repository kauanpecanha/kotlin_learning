package br.com.kauanpecanha.alugames.models

import Jogo

data class Aluguel(val gamer: Gamer, val jogo: Jogo) {
    override fun toString(): String {
        return "Aluguel do jogo ${jogo.titulo} por ${gamer.name}"
    }
}