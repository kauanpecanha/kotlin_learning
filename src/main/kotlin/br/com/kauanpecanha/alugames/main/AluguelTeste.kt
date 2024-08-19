package br.com.kauanpecanha.alugames.main
import br.com.kauanpecanha.alugames.models.Aluguel
import br.com.kauanpecanha.alugames.models.Periodo
import br.com.kauanpecanha.alugames.services.ApiConsume
import java.time.LocalDate

fun main() {

    val apiConsumer = ApiConsume()

    val selectedGamer = apiConsumer.findGamers()[3]

    val selectedGame1 = apiConsumer.findGames()[10]
    val selectedGame2 = apiConsumer.findGames()[13]
    val selectedGame3 = apiConsumer.findGames()[2]

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))

//    val aluguel1: Aluguel = Aluguel(selectedGamer, selectedGame1, periodo1)
//    val aluguel2: Aluguel = Aluguel(selectedGamer, selectedGame2, periodo2)
//    val aluguel3: Aluguel = Aluguel(selectedGamer, selectedGame3, periodo3)

    selectedGamer.alugarJogo(selectedGame1, periodo1)
    selectedGamer.alugarJogo(selectedGame2, periodo2)
    selectedGamer.alugarJogo(selectedGame3, periodo3)

    println(selectedGamer.rentedGames)

}