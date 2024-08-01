package org.example
// as data classes são formas de se padronizar a resposta de apis independentemente de qual se esteja usando.
// o trecho de código abaixo é responsável por buscar estes dois atributos title e thumb na resposta da api.
// um ponto importante a ser comentado é que as data classes já detém um toString embutido.
data class InfoApiShark(val title:String, val thumb:String)