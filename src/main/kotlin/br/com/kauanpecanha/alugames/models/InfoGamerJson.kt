import br.com.kauanpecanha.alugames.models.Gamer

data class InfoGamerJson(
    val nome: String,
    val email: String,
    val dataNascimento: String,
    val usuario: String
) {
    override fun toString(): String {
        return ("name: $nome | email: $email | bornDate: $dataNascimento | user: $usuario")
    }

    fun createGamer(): Gamer {
        return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
    }
}