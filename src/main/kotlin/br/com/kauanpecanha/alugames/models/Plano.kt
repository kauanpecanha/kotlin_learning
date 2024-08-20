package br.com.kauanpecanha.alugames.models

open class Plano(val tipo: String) {
    fun calculateRent(aluguel: Aluguel): Double {
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}