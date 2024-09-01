package br.com.alura.alugames.dados

import br.com.alura.alugames.modelo.Jogo
import javax.persistence.EntityManager

// A classe DAO é uma classe responsável por reutilizar o código de read e create de objetos.
// TModel é um tipo genérico, podendo receber qualquer tipo de dado e fazer sua manipulação
// A notação abaixo <TModel, TEntity> especifica que é um genérico, e as operações abaixo a utilizam
// Além de receber o EntityManager, ele também recebe o tipo da entidade, podendo ser jogo ou gamer, sendo ela do tipo
// classe do tipo da entidade
abstract class DAO <TModel, TEntity> (protected val manager: EntityManager, protected val entityType: Class<TEntity>) {

    // função padrão de transformação de um modelo para uma entidade
    abstract fun toEntity(objeto: TModel): TEntity

    // função padrão de transformação de uma entidade para um modelo
    abstract fun toModel(entity: TEntity): TModel

    // função padrão de busca dos objetos do tipo genérico, de forma a depender do simple name do tipo da entidade
    // podendo ser gamer ou jogo
    open fun getLista(): List<TModel> {
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)
        return query.resultList.map { entity -> toModel(entity) }
    }

    // função padrão de adição de model ao banco de dados
    open fun adicionar(objeto: TModel) {

        // transformação de um modelo para uma entidade
        val entity = toEntity(objeto)

        // operações de adição da entidade ao banco de dados
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()

    }

    open fun recuperarPeloId(id: Int): TModel {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult
        return toModel(entity)
    }

    open fun apagar(id: Int) {
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult

        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }
}