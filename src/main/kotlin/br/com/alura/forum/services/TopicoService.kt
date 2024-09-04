package br.com.alura.forum.services

import br.com.alura.forum.dto.TopicoDTO
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.models.Topico
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) {

    // função de busca por todos os objetos cadastrados
    fun listar(): List<TopicoView> {
        return topicos.stream().map {
            each -> TopicoView(
                id = each.id,
                titulo = each.titulo,
                mensagem = each.mensagem,
                status = each.status,
                dataCriacao = each.dataCriacao
            )
        }.collect(Collectors.toList())
    }

    // função de busca de um objeto específico através de filtragem
    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter {
            each -> each.id == id
        }.findFirst().get()

        return TopicoView(
            topico.id,
            topico.titulo,
            topico.mensagem,
            topico.status,
            topico.dataCriacao
        )

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