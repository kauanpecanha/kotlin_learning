package br.com.kauanpecanha.alugames.main

import br.com.kauanpecanha.alugames.models.Gamer

fun main() {
    val gamer1 = Gamer(name = "Kauan Peçanha", email = "kauanpecanha@gmail.com", bornDate = "25/05/2004", user = "kauanpecanha")

    val gamer2 = Gamer(name = "Isabella Peçanha", email = "isabella@gmail.com", bornDate = "09/10/2008", user = "akiraa")

    println(gamer1.toString())
    println(gamer2.toString())

    // scope functions
    gamer1.let {
        it.bornDate = "25/05/2004"
        it.user = "picanha"
    }

}