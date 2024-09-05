package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicoView

// os mappers visam efetuar transformações de classes para outras, como por exemplo, de Forms para Views

// classe que estabelece um mapper genérico para ser utilizado pelas demais classes
interface Mapper<T, U> {
    fun map(t: T): U
}

// classe que estavelece um mapper genérico customizado para solucionar o problema de não acesso ao id do objeto
// ela recebe um valor l que já é correspondente ao id do objeto a ser atribuído
interface MapperWithList<T, U> {
    fun map(t: T, l: Long): U
}
