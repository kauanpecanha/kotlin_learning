package br.com.alura.alugames.modelo

 class PlanoAvulso(
    tipo: String,
    id: Int = 0
 ): Plano(tipo) {

     override fun obterValor(aluguel: Aluguel): Double {
         var valorOriginal = super.obterValor(aluguel)
         if (aluguel.gamer.media > 8) {
             valorOriginal -= valorOriginal * 0.1
         }
         return valorOriginal
     }
}
