package br.com.alura.alugames.principal

import br.com.alura.alugames.banco.Banco
import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.banco.JogosDAO

// script de interação com os bancos de dados
fun main() {

    val jogoTheLastOfUs: Jogo = Jogo(
        "The Last of Us Part I",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        5.99,
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito."
    )

    val jogosDAO = JogosDAO()

//    jogosDAO.adicionarJogo(jogoTheLastOfUs)

    val listaJogos: List<Jogo> = jogosDAO.getJogos()

    println(listaJogos)
}