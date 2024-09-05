package br.com.alura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

// TopicoForm é uma classe que visa representar os dtos de entrada

// classe que valida os dados de entrada do corpo da api através das tags abaixo
// @field: NotEmpty -> campos não vazios
// @field: Size(min = 5, max = 100) -> campo de 5 a 100 caracteres
data class TopicoForm (
    @field: NotEmpty @field: Size(min = 5, max = 100) val titulo: String,
    @field: NotEmpty val mensagem: String,
    @field: NotNull val idCurso: Long,
    @field: NotNull val idAutor: Long
)
