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
    val meuJogo = gson.fromJson(json, InfoJogo::class.java)

    // instanciação de um novo objeto do tipo jogo
    //    val meuJogo = Jogo(
    //        titulo = "Batman: Arkham Asylum Game of The Year Edition",
    //        capa = "https:\\\\/\\\\/shared.akamai.steamstatic.com\\\\/store_item_assets\\\\/steam\\\\/apps\\\\/35140\\\\/capsule_sm_120.jpg?t=1702934705"
    //    )

    println(meuJogo)
}