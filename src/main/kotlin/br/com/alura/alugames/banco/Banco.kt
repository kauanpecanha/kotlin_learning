package br.com.alura.alugames.banco

import br.com.alura.alugames.modelo.Jogo
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Banco {
    fun obterConexao(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "root")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }

    fun getJogos(): List<Jogo> {
        val listaJogos = mutableListOf<Jogo>()

        val conexao = this.obterConexao()

        if (conexao != null) {
            try {
                // criação de statement para execução do código
                val statement = conexao.createStatement()

                // comando de pesquisa no banco de dados
                val resultado = statement.executeQuery("select * from jogos")

                // loop para mapear todos os objetos advindos do banco de dados
                while(resultado.next()) {
                    // captura do id do objeto
                    val id = resultado.getInt("id")
                    val titulo = resultado.getString("titulo")
                    val capa = resultado.getString("capa")
                    val descricao = resultado.getString("descricao")
                    val preco = resultado.getDouble("preco")

                    // criação do objeto jogo
                    val jogo = Jogo(titulo, capa, preco, descricao, id)

                    // adição do jogo à lista
                    listaJogos.add(jogo)
                }

                // encerramento do statement
                statement.close()
            } finally {
                // encerramento da conexao
                conexao.close()
            }
        }

        return listaJogos
    }
}