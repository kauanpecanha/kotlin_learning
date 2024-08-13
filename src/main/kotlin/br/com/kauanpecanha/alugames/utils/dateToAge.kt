package br.com.kauanpecanha.alugames.utils
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.convertDateToAge(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var age = 0
    val bornDate = LocalDate.parse(this, formatter)
    val today = LocalDate.now()

    age = Period.between(bornDate, today).years

    return age
}