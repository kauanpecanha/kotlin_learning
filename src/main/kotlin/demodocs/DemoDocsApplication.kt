package demodocs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoDocsApplication

fun main(args: Array<String>) {
    runApplication<DemoDocsApplication>(*args)
}
