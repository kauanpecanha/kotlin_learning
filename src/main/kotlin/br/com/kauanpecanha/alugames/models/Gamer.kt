package br.com.kauanpecanha.alugames.models

import Jogo
import java.util.*
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

    val searchedGames: MutableList<Jogo?> = mutableListOf<Jogo?>()
    val rentedGames: MutableList<Aluguel> = mutableListOf<Aluguel>()
    val plano: PlanoAvulso = PlanoAvulso("BRONZE")

    // construtor secundário
    constructor(name: String, email: String, bornDate: String, user: String)
        : this(name, email) {
            this.name = name
            this.user = user
            this.bornDate = bornDate
            createUserId()
        }

    // init é utilizado para efetuar alguma operação imediatamente após a criação do objeto, depois do contrutor.
    // Dessa forma, é possível tratar dados utilizando alguns métodos.
//    init {
//        // expressão para verificar se um nome está vazio ou nulo
//        if (name.isNullOrBlank()) {
//            // retorno de uma excpection
//            throw IllegalArgumentException("Name is required")
//        }
//        // utilização da função criada para validar o email
//        this.email = validateEmail()
//    }

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

    // função para alugar um determinado jogo
    fun alugarJogo(jogo: Jogo, periodo: Periodo): Aluguel {
        // nova instância do objeto aluguel
        val rent = Aluguel(this, jogo, periodo)
        // adição da nova instância à lista
        rentedGames.add(rent)
        // retorno da nova instância para impressão de suas informações
        return rent
    }

    // companion objects são uma forma de criar atributos e métodos estáticos,
    // ou seja, que podem ser acessados diretamente na classe, sem precisar 
    // criar uma instância dessa classe
    companion object {
        
        // função de criação de instância de Gamer para armazenar todos os jogos
        // buscados por ele
        fun createGamer(leitura: Scanner): Gamer {
            
            // dados básicos de cadastro
            println("Entre com seu nome: ")
            val name = leitura.nextLine()
            println("Entre com seu email: ")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro de usuário?")
            val option = leitura.nextLine()

            // se desejado completar o cadastro
            if(option.equals("s", true)) {
                println("Entre com sua data de nascimento(dd/mm/aaaa):")
                val bornDate = leitura.nextLine()
                println("Entre com seu nome de usuário: ")
                val username = leitura.nextLine()

                // retorno da instância com as informações completas
                return Gamer(name, email, bornDate, username)
            }

            // do contrário
            // retorno da instância apenas com as informações básicas
            return Gamer(name, email)
        }
    }

}