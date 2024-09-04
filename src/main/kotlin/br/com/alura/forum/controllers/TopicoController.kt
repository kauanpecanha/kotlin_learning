package br.com.alura.forum.controllers

import br.com.alura.forum.models.Curso
import br.com.alura.forum.models.Topico
import br.com.alura.forum.models.Usuario
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController {

    @GetMapping
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