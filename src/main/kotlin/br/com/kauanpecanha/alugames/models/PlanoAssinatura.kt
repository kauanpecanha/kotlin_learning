package br.com.kauanpecanha.alugames.models

// a classe PlanoAssinatura herda tudo aquilo da classe Plano. Isto é feito através
// de :Plano(tipo) antes da abertura do escopo através dos colchetes. Um exemplo
// de herança é o tipo de plano, que não precisou ser declarado com val no construtor
// de PlanoAssinatura
class PlanoAssinatura(tipo: String, val mensalidade: Double, val jogosIncluidos: Int): Plano(tipo) {

}