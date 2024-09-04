package br.com.alura.forum.services

import br.com.alura.forum.dto.TopicoDTO
import br.com.alura.forum.models.Topico
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) {

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

    fun cadastrar(dto: TopicoDTO) {
        topicos = topicos.plus(Topico(
            id = (topicos.size + 1).toLong(),
            titulo = dto.titulo,
            mensagem = dto.mensagem,
            curso = cursoService.buscarPorId(dto.idCurso),
            autor = usuarioService.buscarPorId(dto.idAutor),
        ))
    }
}