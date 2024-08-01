package org.example

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner


fun main() {

    // criando um scanner para leitura de valores pelo teclado
    val leitura = Scanner(System.`in`)
    // mensagem no prompt do usuário
    println("Entre com o código do jogo desejado: ")
    // leitura do valor digitado pelo usuário
    val busca = leitura.nextLine()

    // criação de um cliente para fazer requisições na api
    val client: HttpClient = HttpClient.newHttpClient()

    // criação de uma nova instância de request
    val request = HttpRequest.newBuilder()
        // endpoint com o id especificado pelo usuário
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$busca"))
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

    try {
        val meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
        println(meuJogo)

    } catch (ex: NullPointerException) {
        println("Jogo inexistente. Tente outro id.")
    }
}