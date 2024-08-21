package br.com.kauanpecanha.alugames.models

import br.com.alura.alugames.models.Jogo

data class InfoJogoJson(
    val titulo: String,
    val capa: String,
    val preco: Double,
    val descricao: String) {

    fun createGame(): Jogo {
        return Jogo(this.titulo, this.capa, this.preco, this.descricao)
    }
}