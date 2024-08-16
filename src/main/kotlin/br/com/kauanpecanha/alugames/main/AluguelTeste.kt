package br.com.kauanpecanha.alugames.main
import br.com.kauanpecanha.alugames.models.Aluguel
import br.com.kauanpecanha.alugames.services.ApiConsume

fun main() {

    val apiConsumer = ApiConsume()

    val selectedGamer = apiConsumer.findGamers()[3]
    val selectedGame = apiConsumer.findGames()[10]

    println(selectedGamer)
    println(selectedGame)

    val aluguel: Aluguel = Aluguel(selectedGamer, selectedGame)

    println(aluguel)

}