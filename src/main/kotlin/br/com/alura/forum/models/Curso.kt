package br.com.alura.forum.models

// entidade para representar os cursos da plataforma
data class Curso (
    val id: Long? = null,
    val nome: String,
    val categoria: String,
)
