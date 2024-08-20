package br.com.kauanpecanha.alugames.models

abstract class Plano(val tipo: String) {
    open fun calculateRent(aluguel: Aluguel): Double {
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }
}