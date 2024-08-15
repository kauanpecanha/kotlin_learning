package br.com.kauanpecanha.alugames.models

data class InfoGamerJson(
    val nome: String,
    val email: String,
    val dataNascimento: String,
    val usuario: String
) {
    override fun toString(): String {
        return ("name: $nome | email: $email | bornDate: $dataNascimento | user: $usuario")
    }
}