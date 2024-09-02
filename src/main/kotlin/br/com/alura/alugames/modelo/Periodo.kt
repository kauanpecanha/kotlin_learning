package br.com.alura.alugames.modelo

import java.time.LocalDate
import java.time.Period
import javax.persistence.Embeddable

// a tag abaixo permite que a classe Periodo seja embutida em qualquer tabela que o desenvolvedor deseje
@Embeddable
data class Periodo(
    val dataInicial: LocalDate = LocalDate.now(),
    val dataFinal: LocalDate = LocalDate.now().plusDays(7)
) {
    val emDias = Period.between(dataInicial, dataFinal).days
}
