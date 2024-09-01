package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager

// classe que contém todas as operações de bancos de dados com os jogos inclusos. algo semelhante aos controllers do js

// : DAO<Jogo, JogoEntity> é uma forma de herança da classe DAO para operações de read e create
class JogosDAO(manager: EntityManager): DAO<Jogo, JogoEntity>(manager, JogoEntity::class.java) {

    // sobrescrita da função de transformação de um model para uma entidade
    override fun toEntity(objeto: Jogo): JogoEntity {
        return JogoEntity(objeto.titulo, objeto.capa, objeto.preco, objeto.descricao, objeto.id)
    }

    // sobrescrita da função de transformação de uma entidade para um model
    override fun toModel(entity: JogoEntity): Jogo {
        return Jogo(entity.titulo, entity.capa, entity.preco, entity.descricao, entity.id)
    }

    // os overrides abaixo são para adequar as funções herdadas ao contexto do objeto jogo
}