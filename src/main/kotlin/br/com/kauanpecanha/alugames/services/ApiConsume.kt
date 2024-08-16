package br.com.kauanpecanha.alugames.services

import InfoGamerJson
import Jogo
import br.com.kauanpecanha.alugames.models.Gamer
import br.com.kauanpecanha.alugames.models.InfoJogoJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ApiConsume {

    private fun getResponseFromApi(apiAddress: String): String {
        // criação de um cliente para fazer requisições na api
        val client: HttpClient = HttpClient.newHttpClient()

        // criação de uma nova instância de request
        val request = HttpRequest.newBuilder()
            // endpoint com o id especificado pelo usuário
            .uri(URI.create(apiAddress))
            .build()

        // variável para armazenamento da resposta obtida
        val response = client.send(request, BodyHandlers.ofString())

        // json com a resposta
        return response.body()

    }

    fun findGames():List<Jogo> {

        val json = getResponseFromApi("https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json")

        val gson = Gson()
        val meuJogoTipo = object : TypeToken<List<InfoJogoJson>>() {}.type
        val listaJogo: List<InfoJogoJson> = gson.fromJson(json, meuJogoTipo)
        val convertedGamesList = listaJogo.map { infoJogoJson -> infoJogoJson.createGame() }

        return convertedGamesList
    }

    fun findGamers():List<Gamer> {

        val json = this.getResponseFromApi("https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json")

        val gson = Gson()

        // a linha de código abaixo é necessária, uma vez que cria um objeto anônimo do tipo <List<InfoGamerJson>
        // a necessidade da mesma decorre do fato de, em tempo de execução, o kotlin apaga as informações de tipos
        // genéricos
        val gamerType = object: TypeToken<List<InfoGamerJson>>() {}.type
        val listGamers: List<InfoGamerJson> = gson.fromJson(json, gamerType)

        val convertedListGamer = listGamers.map { infoGamerJson -> infoGamerJson.createGamer() }

        return convertedListGamer
    }

}