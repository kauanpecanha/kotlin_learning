package br.com.alura.alugames.dados
import br.com.alura.alugames.modelo.Periodo
import javax.persistence.*

@Entity
@Table (name = "aluguel")
open class AluguelEntity(
    // tag para indicar que são vários aluguéis para um gamer, na cardinalidade de banco de dados relacionais.
    @ManyToOne
    val gamer: GamerEntity = GamerEntity(),

    // tag para indicar que são vários aluguéis para um jogo, na cardinalidade de banco de dados relacionais.
    @ManyToOne
    val jogo: JogoEntity = JogoEntity(),

    @Embedded
    val periodo: Periodo = Periodo()
) {
    var valorAluguel: Double = 0.0

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0
}