package br.com.alura.forum.dto

import br.com.alura.forum.models.StatusTopico
import java.time.LocalDateTime

// TopicoView é uma classe que visa representar os dados de saída para visualização do usuário

data class TopicoView (
    val id: Long,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
)