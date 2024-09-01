package br.com.alura.alugames.principal

import br.com.alura.alugames.dados.Banco
import br.com.alura.alugames.modelo.Jogo
import br.com.alura.alugames.dados.JogosDAO

// script de interação com os bancos de dados
fun main() {

    val jogo = Jogo("The Last of Us Part I", "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554", 5.99,"Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito.")
    val jogo2 = Jogo("Dandara", "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293", 9.99,"Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania.")

    val manager = Banco.getEntityManager()

    val jogosDAO = JogosDAO(manager)
    //    jogosDAO.adicionar(jogo)
    //    jogosDAO.adicionar(jogo2)

    val jogoRecuperado = jogosDAO.recuperarPeloId(11)
    println(jogoRecuperado)

    jogosDAO.apagar(12)

    val listaJogos: List<Jogo> = jogosDAO.getLista()

    println(listaJogos)

    manager.close()
}