package br.com.kauanpecanha.alugames.main
import br.com.kauanpecanha.alugames.services.ApiConsume
import br.com.kauanpecanha.alugames.utils.createGamer

fun main() {

    val apiConsumer = ApiConsume()

    // função que retorna a lista de objetos dos gamers, do tipo JSON
    val gamersListJson = apiConsumer.findGamers()

    // teste do get da api após refactor
    val game = apiConsumer.findGame(150)

    // conversão da lista do tipo json para o tipo GAMER
    val gamersListGamer = gamersListJson.map {

        // utilização de extension function para conversão
        each -> each.createGamer()
    }

    // impressão do resultado
    println(gamersListGamer)

    // impressão do resultado do get da api de games após refactor
    println(game)

}