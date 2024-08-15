package br.com.kauanpecanha.alugames.utils

import br.com.kauanpecanha.alugames.models.Gamer
import br.com.kauanpecanha.alugames.models.InfoGamerJson

fun InfoGamerJson.createGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}