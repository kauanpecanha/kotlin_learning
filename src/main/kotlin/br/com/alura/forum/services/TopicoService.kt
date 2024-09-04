package br.com.alura.forum.services

import br.com.alura.forum.models.Curso
import br.com.alura.forum.models.Topico
import br.com.alura.forum.models.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService {
    fun listar(): List<Topico> {

        val topico = Topico(1,
            "Dúvida de Kotlin",
            "Variáveis no Kotlin",
            curso = Curso(id = 1, nome = "Kotlin", categoria = "Programação"),
            autor = Usuario(id = 1, "Ana da Silva", "ana@email.com"),
        )

        return Arrays.asList(topico, topico, topico)
    }
}