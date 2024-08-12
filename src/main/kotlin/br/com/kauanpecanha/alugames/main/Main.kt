package br.com.kauanpecanha.alugames.main

import br.com.kauanpecanha.alugames.models.Gamer
import br.com.kauanpecanha.alugames.services.ApiConsume
import org.example.br.com.kauanpecanha.alugames.models.Jogo
import java.util.*


fun main() {

    val leitura = Scanner(System.`in`)
    val gamer = Gamer.createGamer(leitura)
    println("Cadastro concluído com sucesso!")

    var meuJogo: Jogo? = null

    println(gamer)

    do {

        println("Entre com o código do jogo desejado: ")
        val busca = leitura.next().toInt()

        val buscaApi = ApiConsume()
        val meuInfoJogo = buscaApi.findOne(busca)
        val resultado = runCatching {
            meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
        }

        resultado.onFailure {
            println("Jogo inexistente. Tente outro id.")
        }
        resultado.onSuccess {
            println("Gostaria de adicionar uma descrição ao jogo? S/N")
            val opcao = Scanner(System.`in`).nextLine()

            if (opcao.equals("S", true)) {
                println("Insira a descrição que gostaria de adicionar a este jogo: ")
                val descricaoPersonalizada = Scanner(System.`in`).nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }
            println(meuJogo)
            gamer.searchedGames.add(meuJogo)
        }

        println("Gostaria de adicionar mais um jogo à sua lista? S/N")
        val option = leitura.next()

        // enquanto a opção for positiva
    } while (option.equals("S", true))

    println("\nJogos buscados:")
    println(gamer.searchedGames)

    println("\nJogos ordenados por título:")
    gamer.searchedGames.sortBy {
        it?.titulo
    }

    gamer.searchedGames.forEach {
        println("Título: ${it?.titulo}")
    }

    println("\nJogos que contém a palavra Batman")
    val filteredGames = gamer.searchedGames.filter {
        it?.titulo?.contains("batman", true) ?: false
    }

    println(filteredGames)

//    println("\nGostaria de deletar algum jogo?")
//    val option = leitura.next()
//
//    if (option.equals("S", true)) {
//        gamer.searchedGames.forEach {
//            println("${it?.titulo}")
//        }
//        println("Qual índice você gostaria de deletar?")
//        val indexToDelete = leitura.next().toInt()
//
//        gamer.searchedGames.removeAt(indexToDelete)
//    }
//
//    println("Lista atualizada sem o jogo deletado:")
//    gamer.searchedGames.forEach {
//        println("${it?.titulo}")
//    }
//    println("Jogos deletados")

}