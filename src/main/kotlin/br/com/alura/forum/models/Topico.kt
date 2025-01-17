package br.com.alura.forum.models

import java.time.LocalDateTime
import java.util.ArrayList

// entidade principal deste curso para representar os tópicos de discussão do forum
data class Topico (
    var id: Long,
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val curso: Curso,
    val autor: Usuario,
    val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    val respostas: List<Resposta> = ArrayList()
)