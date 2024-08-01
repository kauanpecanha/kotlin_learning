package org.example.br.com.kauanpecanha.alugames.main
import br.com.kauanpecanha.alugames.services.ApiConsume
import org.example.br.com.kauanpecanha.alugames.models.Jogo
import java.util.*


fun main() {

    // criando um scanner para leitura de valores pelo teclado
    val leitura = Scanner(System.`in`)
    // mensagem no prompt do usuário
    println("Entre com o código do jogo desejado: ")
    // leitura do valor digitado pelo usuário
    val busca: Int = leitura.nextLine().toInt()

    val buscaApi = ApiConsume()

    val meuInfoJogo = buscaApi.findOne(busca)

    var meuJogo: Jogo? = null

    val resultado = runCatching {
        meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
    }

    resultado.onFailure {
        println("Jogo inexistente. Tente outro id.")
    }

    resultado.onSuccess {
        println("Gostaria de adicionar uma descrição ao jogo? S/N")
        val opcao = Scanner(System.`in`).nextLine()

        if(opcao.equals("S", true)) {
            println("Insira a descrição que gostaria de adicionar a este jogo: ")
            val descricaoPersonalizada = Scanner(System.`in`).nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }

        println(meuJogo)
    }

    resultado.onSuccess {
        println("Operação efetuada com sucesso!")
    }
}