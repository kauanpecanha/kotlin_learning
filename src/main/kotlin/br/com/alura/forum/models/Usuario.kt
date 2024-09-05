package br.com.alura.forum.models

// entidade para representar os usuários do forum
data class Usuario (
    var id: Long? = null,
    val nome: String,
    val email: String
)