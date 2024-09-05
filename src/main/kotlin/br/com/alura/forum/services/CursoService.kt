package br.com.alura.forum.services

import br.com.alura.forum.models.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(
    var cursos: List<Curso>
) {
    init {
        val curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        )

        cursos = Arrays.asList(curso)
    }

    fun buscarPorId(id: Long): Curso {
        return cursos.stream().filter({ each ->
            each.id == id
        }).findFirst().get()
    }
}
