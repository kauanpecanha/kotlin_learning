package br.com.kauanpecanha.alugames.models

class PlanoAvulso(tipo: String): Plano(tipo) {

    // override da função original para o caso específico do PlanoAvulso
    override fun calculateRent(aluguel: Aluguel): Double {

        // captura do valor original do aluguel
        var originalValue = super.calculateRent(aluguel)

        // se a reputação do gamer for superior a 8
        if(aluguel.gamer.media > 8) {

            // obtém-se 10% de desconto
            originalValue -= originalValue * (0.1)
        }

        // retorno do valor
        return originalValue
    }
}
