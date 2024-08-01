import kotlin.reflect.typeOf
import kotlin.Nothing as Null

fun sumTwoNumbers(a: Int, b: Int): Int{
    return a + b
}

fun decreaseTwoNumbers(a: Int, b: Int): Int {
    if (b > a) {
        return 0
    }
    else {
        return a - b
    }
}

fun multiplyTwoNumbers(a: Int, b: Int): Int{
    return a * b
}

fun divideTwoNumbers(a: Int, b: Int): Float{
    if(a % b == 0){
        return a/b.toFloat()
    }
    else {
        return a.toFloat()/b.toFloat()
    }
}

fun main() {
    println("Qual operação deseja performar?")
    val option= readln()

    if(option !is Int){
        println("Entre com uma opção válida")
    }
    println(option)

}