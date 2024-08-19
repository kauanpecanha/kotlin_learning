package br.com.kauanpecanha.alugames.main
import br.com.kauanpecanha.alugames.models.Aluguel
import br.com.kauanpecanha.alugames.models.Periodo
import br.com.kauanpecanha.alugames.services.ApiConsume
import java.time.LocalDate

fun main() {

    val apiConsumer = ApiConsume()

    val selectedGamer = apiConsumer.findGamers()[3]
    val selectedGame = apiConsumer.findGames()[10]

    println(selectedGamer)
    println(selectedGame)

    val aluguel: Aluguel = Aluguel(selectedGamer, selectedGame, Periodo(LocalDate.now(), LocalDate.now().plusDays(7)))

    println(aluguel)

}