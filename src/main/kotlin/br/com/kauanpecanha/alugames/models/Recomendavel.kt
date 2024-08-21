package br.com.kauanpecanha.alugames.models

interface Recomendavel {
    val media: Double
    fun recomendar(nota: Int)
}