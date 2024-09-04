package br.com.alura.forum.services

import br.com.alura.forum.dto.TopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.models.Topico
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper
) {

    // função de busca por todos os objetos cadastrados
    fun listar(): List<TopicoView> {
        return topicos.stream().map {
            each -> topicoViewMapper.map(each)
        }.collect(Collectors.toList())
    }

    // função de busca de um objeto específico através de filtragem
    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter {
            each -> each.id == id
        }.findFirst().get()

        return topicoViewMapper.map(topico)

    }

    fun cadastrar(form: TopicoForm) {
        val topico = topicoFormMapper.map(form)
        topico.id = (topicos.size + 1).toLong()
        topicos = topicos.plus(topicoFormMapper.map(form))
    }
}