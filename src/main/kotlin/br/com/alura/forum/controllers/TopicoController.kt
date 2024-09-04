package br.com.alura.forum.controllers

import br.com.alura.forum.models.Curso
import br.com.alura.forum.models.Topico
import br.com.alura.forum.models.Usuario
import br.com.alura.forum.services.TopicoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val service: TopicoService
) {

    @GetMapping
    fun listar(): List<Topico>{
        return service.listar()
    }

    /*
    * a função abaixo faz algumas coisas:
    *   1 - especifica a rota específica que deseja receber a requisição
    *   2 - pela rota, consegue receber um parâmetro para seu uso interno
    *
    * dessa forma, é possível receber parâmetros através de uris
    *
    * */
    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Topico {
        return service.buscarPorId(id)
    }
}