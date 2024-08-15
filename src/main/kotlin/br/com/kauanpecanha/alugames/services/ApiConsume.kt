package br.com.kauanpecanha.alugames.services

import br.com.kauanpecanha.alugames.models.InfoGamerJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.example.br.com.kauanpecanha.alugames.models.InfoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ApiConsume {

    fun findOne(id:Int):InfoJogo {
        // criação de um cliente para fazer requisições na api
        val client: HttpClient = HttpClient.newHttpClient()

        // criação de uma nova instância de request
        val request = HttpRequest.newBuilder()
            // endpoint com o id especificado pelo usuário
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$id"))
            // ?
            .build()

        // variável para armazenamento da resposta obtida
        val response = client
            // request
            .send(request, BodyHandlers.ofString())

        // json com a resposta
        val json = response.body()

        val gson = Gson()
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfoJogo
    }

    fun findGamers():List<InfoGamerJson> {
        // criação de um cliente para fazer requisições na api
        val client: HttpClient = HttpClient.newHttpClient()

        // criação de uma nova instância de request
        val request = HttpRequest.newBuilder()
            // endpoint com o id especificado pelo usuário
            .uri(URI.create("https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"))
            // ?
            .build()

        // variável para armazenamento da resposta obtida
        val response = client
            // request
            .send(request, BodyHandlers.ofString())

        // json com a resposta
        val json = response.body()

        val gson = Gson()

        // a linha de código abaixo é necessária, uma vez que cria um objeto anônimo do tipo <List<InfoGamerJson>
        // a necessidade da mesma decorre do fato de, em tempo de execução, o kotlin apaga as informações de tipos
        // genéricos
        val gamerType = object: TypeToken<List<InfoGamerJson>>() {}.type
        val listGamers: List<InfoGamerJson> = gson.fromJson(json, gamerType)

        return listGamers
    }
}