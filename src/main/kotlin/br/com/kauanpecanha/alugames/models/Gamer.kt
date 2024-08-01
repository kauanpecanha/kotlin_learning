package br.com.kauanpecanha.alugames.models

data class Gamer(var name: String, var email: String) {
    // construtor primário
    var bornDate: String? = null
    var user: String? = null
    var id: String? = null

    // construtor secundário
    constructor(name: String, email: String, bornDate: String, user: String)
        : this(name, email) {
            this.name = name
            this.user = user
        }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', bornDate=$bornDate, user=$user, id=$id)"
    }

}