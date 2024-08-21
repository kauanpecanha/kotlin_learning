package br.com.kauanpecanha.alugames.models

// a classe PlanoAssinatura herda tudo aquilo da classe Plano. Isto é feito através
// de :Plano(tipo) antes da abertura do escopo através dos colchetes. Um exemplo
// de herança é o tipo de plano, que não precisou ser declarado com val no construtor
// de PlanoAssinatura
class PlanoAssinatura(tipo: String, val mensalidade: Double, val jogosIncluidos: Int, val discountPercent: Double): Plano(tipo) {

    // função de cálculo adaptada para a realidade do plano de assinatura
    override fun calculateRent(aluguel: Aluguel): Double {

        // calcula a quantidade de jogos alugados no mês para se obter seus preços de acordo
        // com a quantidade prevista pelo plano
        val totalJogosMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size + 1

        // return if é um condicional no qual o if é responsável por determinar aquilo que
        // será retornado pelo mesmo
        return if(totalJogosMes <= jogosIncluidos) {
            // 0 se estiver dentro da quantidade de jogos inclusos
            0.0
        } else {
            // valor original da locação
            var originalValue = super.calculateRent(aluguel)
            // se areputação do gamer estiver acima de 8
            if(aluguel.gamer.media > 8) {
                // desconto de x % sobre o valor do game
                originalValue -= (originalValue * discountPercent)
            }
            // retorno do valor, entrando ele na condição acima ou não
            originalValue
        }
    }
}