package br.com.alura.forum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topico(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var titulo: String,
        var mensagem: String,
        val dataCriacao: LocalDateTime = LocalDateTime.now(),
        @ManyToOne // vários tópicos estão relacionados a um curso
        val curso: Curso,
        @ManyToOne // vários tópicos estão atrelado a um usuário
        val autor: Usuario,
        @Enumerated(value = EnumType.STRING) // será salvo o nome do estado no banco de dados
        val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
        @OneToMany(mappedBy = "topico") // um tópico tem várias respostas
        val respostas: List<Resposta> = ArrayList()
)