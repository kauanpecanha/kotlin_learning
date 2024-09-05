package br.com.alura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicoForm (
    @NotEmpty @Size(min = 5, max = 100) val titulo: String,
    @NotEmpty val mensagem: String,
    @NotNull val idCurso: Long,
    @NotNull val idAutor: Long
)
