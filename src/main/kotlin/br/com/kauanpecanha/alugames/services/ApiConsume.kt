package br.com.kauanpecanha.alugames.services

import com.google.gson.Gson
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
}