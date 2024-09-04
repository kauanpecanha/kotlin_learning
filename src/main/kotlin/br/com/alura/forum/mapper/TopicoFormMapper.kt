package br.com.alura.forum.mapper

import br.com.alura.forum.models.Topico
import br.com.alura.forum.dto.TopicoForm
import br.com.alura.forum.services.CursoService
import br.com.alura.forum.services.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,

    ): Mapper<TopicoForm, Topico> {
    fun map(t: TopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor),
        )
    }

}
