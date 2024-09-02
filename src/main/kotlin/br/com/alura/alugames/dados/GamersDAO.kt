import br.com.alura.alugames.dados.DAO
import br.com.alura.alugames.dados.GamerEntity
import br.com.alura.alugames.modelo.Gamer
import br.com.alura.alugames.utilitario.toEntity
import br.com.alura.alugames.utilitario.toModel
import javax.persistence.EntityManager

class GamersDAO(manager: EntityManager): DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {

    override fun toEntity(objeto: Gamer): GamerEntity {
        return GamerEntity(
            objeto.id,
            objeto.nome,
            objeto.email,
            objeto.dataNascimento,
            objeto.usuario,
            objeto.plano.toEntity()
        )
    }

    override fun toModel(entity: GamerEntity): Gamer {
        // note que nenhum construtor de gamer oferece a possibilidade de alterar o atributo do plano. por isso foi
        // utilizado a scope function apply
        return Gamer(
            entity.nome,
            entity.email,
            entity.dataNascimento,
            entity.usuario, entity.id)
            .apply {
                plano = entity.plano.toModel()
            }
    }
}