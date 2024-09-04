package br.com.alura.forum.services

import br.com.alura.forum.models.Curso
import br.com.alura.forum.models.Topico
import br.com.alura.forum.models.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(
    private var topicos: List<Topico>,
) {

    // os objetos abaixo serão automaticamente criados quando um objeto do tipo TopicoService for criado
    init {
        val topico1 = Topico(1,
            "Primeira dúvida de Kotlin",
            "Variáveis no Kotlin",
            curso = Curso(id = 1, nome = "Kotlin", categoria = "Programação"),
            autor = Usuario(id = 1, "Ana da Silva", "ana@email.com"),
        )

        val topico2 = Topico(2,
            "Segunda dúvida de Kotlin",
            "Classes no Kotlin",
            curso = Curso(id = 1, nome = "Kotlin", categoria = "Programação"),
            autor = Usuario(id = 2, "João da Silva", "joao@email.com"),
        )

        val topico3 = Topico(3,
            "Terceira dúvida de Kotlin",
            "Data Classes no Kotlin",
            curso = Curso(id = 1, nome = "Kotlin", categoria = "Programação"),
            autor = Usuario(id = 3, "Bia da Silva", "bia@email.com"),
        )

        // atribuição da lista de tópicos à variável topicos
        topicos = Arrays.asList(topico1, topico2, topico3)
    }

    // função de busca por todos os objetos cadastrados
    fun listar(): List<Topico> {
        return topicos
    }

    // função de busca de um objeto específico através de filtragem
    fun buscarPorId(id: Long): Topico {
        return topicos.stream().filter({
            each -> each.id == id
        }).findFirst().get()

    }
}