package br.com.alura.forum.services

import br.com.alura.forum.models.Curso
import br.com.alura.forum.models.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(
    var usuarios: List<Usuario>
) {

    init {
        val usuario = Usuario(id = 1,
            nome = "Ana da Silva",
            email = "ana@email.com"
        )

        usuarios = Arrays.asList(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter({
            each -> each.id == id
        }).findFirst().get()
    }
}
