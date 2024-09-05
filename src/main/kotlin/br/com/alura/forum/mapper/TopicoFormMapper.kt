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
) : MapperWithList<TopicoForm, Topico> {

    // override da função map herdada do MapperWithList genérico, esatabelecendo que será feita uma passagem de
    // TopicoForm(entrada) para Topico para manipulação interna de dados pelo software
    override fun map(t: TopicoForm, l: Long): Topico {

        // retorno do objeto no formato de Tópico, com id atribuído
        return Topico(
            id = l,
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor),
        )
    }

}
