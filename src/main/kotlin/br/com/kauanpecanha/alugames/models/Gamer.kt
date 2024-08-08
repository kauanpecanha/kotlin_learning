package br.com.kauanpecanha.alugames.models

import kotlin.random.Random

data class Gamer(var name: String, var email: String) {

    // construtor primário
    var bornDate: String? = null
    var user: String? = null
        // o set é definido para todos que quiserem alterar o user
        set(value) {
            // o valor é capturado
            field = value
            // se o identificador for nulo ou vazio, será criado um novo para determinado usuário
            if(userId.isNullOrBlank()) {
                createUserId()
            }
        }

    var userId: String? = null
        // get é permitido para todos
        get
        // set é privado, ou seja, restrito a mudanças pelo usuário
        private set

    // construtor secundário
    constructor(name: String, email: String, bornDate: String, user: String)
        : this(name, email) {
            this.name = name
            this.user = user
            createUserId()
        }

    // init é utilizado para efetuar alguma operação imediatamente após a criação do objeto, depois do contrutor.
    // Dessa forma, é possível tratar dados utilizando alguns métodos.
    init {
        // expressão para verificar se um nome está vazio ou nulo
        if (name.isNullOrBlank()) {
            // retorno de uma excpection
            throw IllegalArgumentException("Name is required")
        }
        // utilização da função criada para validar o email
        this.email = validateEmail()
    }
    override fun toString(): String {
        return "Gamer(name='$name', email='$email', bornDate=$bornDate, user=$user, userId=$userId)"
    }

    fun createUserId() {

        // criação de um número aleatório com limite definido em 10000
        val numero = Random.nextInt(10000)

        // tag composta por 4 dígitos, atribuida a variavel numero
        val tag = String.format("%04d", numero)

        userId = "$user#$tag"
    }

    // função de validação do email
    fun validateEmail(): String {
        // utilização de regex para verificação do email
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        // se o regex conferir o email
        if(regex.matches(email)) {
            // o email é retornado com sucesso
            return email
        }
        // do contrário, ela retorna uma excpection
        throw IllegalArgumentException("Invalid email format")
    }

}