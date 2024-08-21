package br.com.kauanpecanha.alugames.main
import br.com.kauanpecanha.alugames.models.Gamer
import br.com.kauanpecanha.alugames.services.ApiConsume
import com.google.gson.GsonBuilder
import java.io.File

fun main() {

    val apiConsumer = ApiConsume()

    val gamerCaroline: Gamer = apiConsumer.findGamers()[3]
    val gamerCamila: Gamer = apiConsumer.findGamers()[2]

    val jogoResidentVillage = apiConsumer.findGames()[10]
    val jogoSpider = apiConsumer.findGames()[13]
    val jogoTheLastOfUs = apiConsumer.findGames()[2]
    val jogoDandara = apiConsumer.findGames()[5]
    val jogoAssassins = apiConsumer.findGames()[4]
    val jogoCyber = apiConsumer.findGames()[6]
    val jogoGod = apiConsumer.findGames()[7]
    val jogoSkyrim = apiConsumer.findGames()[18]

    gamerCamila.recommendGame(jogoResidentVillage, 7)
    gamerCamila.recommendGame(jogoTheLastOfUs, 10)
    gamerCamila.recommendGame(jogoAssassins, 8)
    gamerCamila.recommendGame(jogoCyber, 7)
    gamerCamila.recommendGame(jogoGod, 10)
    gamerCamila.recommendGame(jogoDandara, 8)
    gamerCamila.recommendGame(jogoSkyrim, 8)
    gamerCamila.recommendGame(jogoSpider, 6)

    // serializando as informações
    val gsonB = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serialization = gsonB.toJson(gamerCamila.recommendedGames)
    println(serialization)

    // criação de um arquivo com os dados serializados
    val file = File("recommendedGames.json")
    file.writeText(serialization)
    println(file.absolutePath)

}