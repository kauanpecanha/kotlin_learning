package br.com.alura.alugames.banco

import br.com.alura.alugames.modelo.Jogo

// classe que contém todas as operações de bancos de dados com os jogos inclusos. algo semelhante aos controllers do js
class JogosDAO {

    // função de busca de todos os inclusos. semelhante ao get all
    fun getJogos(): List<Jogo> {
        val listaJogos = mutableListOf<Jogo>()
        val conexao = Banco.obterConexao()

        if (conexao != null) {
            try {
                // criação de statement para execução do código
                val statement = conexao.createStatement()
                // comando de pesquisa no banco de dados
                val resultado = statement.executeQuery("SELECT * FROM JOGOS")

                // loop para mapear todos os objetos advindos do banco de dados
                while(resultado.next()) {
                    // captura do id do objeto
                    val id = resultado.getInt("id")
                    val titulo = resultado.getString("titulo")
                    val capa = resultado.getString("capa")
                    val descricao = resultado.getString("descricao")
                    val preco = resultado.getDouble("preco")

                    // criação do objeto jogo
                    val jogo = Jogo(titulo, capa, preco, descricao)
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

    // função de inclusão de um jogo. semelhante ao insertOne
    fun adicionarJogo(jogo: Jogo) {
        val conexao = Banco.obterConexao()

        // string de comando do sql que será executasa somente quanto o statement estiver preparado
        val insert = "INSERT INTO JOGOS (TITULO, CAPA, PRECO, DESCRICAO) VALUES (?,?,?,?)"

        if (conexao != null) {
            try {
                // preparação do statement
                val statement = conexao.prepareStatement(insert)

                // inclusão dos atributos nos respectivos pontos de interrogação
                statement.setString(1, jogo.titulo)
                statement.setString(2, jogo.capa)
                statement.setDouble(3, jogo.preco)
                statement.setString(4, jogo.descricao)

                // efetuação do update dos campos
                statement.executeUpdate()

                // fechamento do statement
                statement.close()
            } finally {
                conexao.close()
            }
        }
    }
}