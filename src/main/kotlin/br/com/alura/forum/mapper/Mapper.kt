package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicoView

interface Mapper<T, U> {
    fun map(t: T): U
}

interface MapperWithList<T, U> {
    fun map(t: T, l: Long): U
}
