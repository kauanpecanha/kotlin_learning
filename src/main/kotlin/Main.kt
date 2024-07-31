package org.example

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    // criação de um cliente para fazer requisições na api
    val client: HttpClient = HttpClient.newHttpClient()

    // criação de uma nova instância de request
    val request = HttpRequest.newBuilder()
        // especificação do endpoint da api
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=146"))
        // ?
        .build()

    // variável para armazenamento da resposta obtida
    val response = client
        // request
        .send(request, BodyHandlers.ofString())

    // json com a resposta
    val json = response.body()

    // visualização da resposta
    println(json)

    val gson = Gson()
    val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
    val meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
    println(meuJogo)
}