package br.com.alura.forum.dto

import br.com.alura.forum.models.StatusTopico
import ch.qos.logback.core.status.Status
import java.time.LocalDateTime

data class TopicoView (
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: StatusTopico,
    val dataCriacao: LocalDateTime
)