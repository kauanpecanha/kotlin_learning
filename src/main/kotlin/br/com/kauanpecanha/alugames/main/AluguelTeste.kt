package br.com.kauanpecanha.alugames.main
import br.com.kauanpecanha.alugames.models.Periodo
import br.com.kauanpecanha.alugames.models.PlanoAssinatura
import br.com.kauanpecanha.alugames.services.ApiConsume
import java.time.LocalDate

fun main() {

    val apiConsumer = ApiConsume()

    val selectedGamer = apiConsumer.findGamers()[3]
    val selectedGamer2 = apiConsumer.findGamers()[5]

    selectedGamer2.plano = PlanoAssinatura("PRATA", 9.90, 3)

    val selectedGame1 = apiConsumer.findGames()[10]
    val selectedGame2 = apiConsumer.findGames()[13]
    val selectedGame3 = apiConsumer.findGames()[2]

    val periodo1 = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))
    val periodo2 = Periodo(LocalDate.now(), LocalDate.now().plusDays(3))
    val periodo3 = Periodo(LocalDate.now(), LocalDate.now().plusDays(10))

    selectedGamer.alugarJogo(selectedGame1, periodo1)
    selectedGamer.alugarJogo(selectedGame2, periodo2)
    selectedGamer.alugarJogo(selectedGame3, periodo3)

    selectedGamer2.alugarJogo(selectedGame1, periodo1)
    selectedGamer2.alugarJogo(selectedGame2, periodo2)
    selectedGamer2.alugarJogo(selectedGame3, periodo3)
    selectedGamer2.alugarJogo(selectedGame3, periodo1)

    selectedGamer.recomendar(7)
    selectedGamer.recomendar(10)
    selectedGamer.recomendar(8)


    println(selectedGamer2.rentedGames)

    println(selectedGamer)

}