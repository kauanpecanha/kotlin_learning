package br.com.alura.alugames.banco

import br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager

// classe que contém todas as operações de bancos de dados com os jogos inclusos. algo semelhante aos controllers do js
class JogosDAO(val manager: EntityManager) {

    fun getJogos(): List<Jogo> {
        val query = manager.createQuery("FROM JogoEntity", JogoEntity::class.java)
        return query.resultList.map { entity -> Jogo(entity.titulo, entity.capa, entity.preco, entity.descricao, entity.Id) }
    }

    fun adicionarJogo(jogo: Jogo) {
        val entity = JogoEntity(jogo.titulo, jogo.capa, jogo.preco, jogo.descricao)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}