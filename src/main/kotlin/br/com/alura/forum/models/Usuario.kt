package br.com.alura.forum.models

data class Usuario (
    var id: Long? = null,
    val nome: String,
    val email: String
)