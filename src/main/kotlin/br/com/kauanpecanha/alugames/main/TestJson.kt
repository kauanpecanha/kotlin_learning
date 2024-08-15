package br.com.kauanpecanha.alugames.main
import br.com.kauanpecanha.alugames.services.ApiConsume
import br.com.kauanpecanha.alugames.models.Gamer
import br.com.kauanpecanha.alugames.utils.createGamer

fun main() {

    val apiConsumer = ApiConsume()

    // função que retorna a lista de objetos dos gamers, do tipo JSON
    val gamersListJson = apiConsumer.findGamers()

    // conversão da lista do tipo json para o tipo GAMER
    val gamersListGamer = gamersListJson.map {

        // utilização de extension function para conversão
        each -> each.createGamer()
    }

    // impressão do resultado
    println(gamersListGamer)

}