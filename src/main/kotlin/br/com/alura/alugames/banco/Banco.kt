package br.com.alura.alugames.banco

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

// instância que estabelece a conexão com o banco de dados
// nota: o object é uma forma de dizer que haverá apenas uma única instância de determinada classe
object Banco {
    fun obterConexao(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "root")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }
}