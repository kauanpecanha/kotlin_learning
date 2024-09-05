package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.models.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper : Mapper<Topico, TopicoView> {

    // override da função map herdada do Mapper comum genérico, para passagem de Tópico para TópicoView(saída)
    override fun map(t: Topico): TopicoView {

        // retorno do objeto do tipo TopicoView
        return TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            status = t.status,
            dataCriacao = t.dataCriacao
        )
    }

}