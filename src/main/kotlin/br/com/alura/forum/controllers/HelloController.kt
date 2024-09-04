package br.com.alura.forum.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController

// especifica a rota de entrada da classe
@RequestMapping("/hello")

// classe que será executada quando a rota for acessada
class helloController {
    // especificando que o request é do tipo get
    @GetMapping
    // função a ser executada
    fun hello(): String {
        // retorno da string
        return "Hello World!"
    }
}