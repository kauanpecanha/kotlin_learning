package br.com.kauanpecanha.alugames.models

import br.com.alura.alugames.models.Jogo
import java.util.*
import kotlin.random.Random

data class Gamer(var name: String, var email: String): Recomendavel {

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
    var plano: Plano = PlanoAvulso("BRONZE")
    val recommendedGames: MutableList<Jogo> = mutableListOf<Jogo>()

    fun recommendGame(jogo: Jogo, nota: Int) {
        jogo.recomendar(nota)
        recommendedGames.add(jogo)
    }

    // lista de notas atribuídas ao gamer para cálculo de recomendação
    private val listaNotas = mutableListOf<Int>()

    // função de adição das notas à lista de notas
    override fun recomendar(nota: Int) {
        if (nota >=0 && nota <= 10) {
            listaNotas.add(nota)
        } else {
            println("A nota ${nota} não foi adicionada, por não estar dentro das condições. Tente novamente com um valor entre 0 e 10.")
        }
    }

    // override da variável media que se torna a média de todas as notas
    override val media: Double
        get() = listaNotas.average()

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
        return "\nGamer: \n" +
                "Name: $name\n" +
                "Email: $email\n" +
                "BornDate: $bornDate\n" +
                "User: $user\n" +
                "id: $userId\n" +
                "Reputação: $media"
    }

    fun createUserId() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)
        userId = "$user#$tag"
    }

    // função de validação do email
    fun validateEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if(regex.matches(email)) {
            return email
        }
        // do contrário, ela retorna uma excpection
        throw IllegalArgumentException("Invalid email format")
    }

    // função para alugar um determinado jogo
    fun alugarJogo(jogo: Jogo, periodo: Periodo): Aluguel {
        val rent = Aluguel(this, jogo, periodo)
        rentedGames.add(rent)
        return rent
    }

    fun jogosDoMes(mes:Int): List<Jogo> {
        return rentedGames
            .filter { aluguel ->  aluguel.periodo.dataInicial.monthValue == mes }
            .map { aluguel ->  aluguel.jogo }
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