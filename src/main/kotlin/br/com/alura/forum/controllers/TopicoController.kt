package br.com.alura.forum.controllers

import br.com.alura.forum.dto.TopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.services.TopicoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicoController(
    private val service: TopicoService
) {

    @GetMapping
    fun listar(): List<TopicoView>{
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
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        return service.buscarPorId(id)
    }

    // rota de cadastro de objetos do tipo topico em uma lista de tópicos
    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: TopicoForm) {
        service.cadastrar(dto)
    }
}