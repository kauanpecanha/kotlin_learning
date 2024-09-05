package br.com.alura.forum.models

import java.time.LocalDateTime

// entidade para representar a entidade respostas de usuários dentro da plataforma
data class Resposta(
    val id: Long?,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val autor: Usuario,
    val topico: Topico,
    val solucao: Boolean
)

