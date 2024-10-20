// MessageService.kt
package demo.services
import demodocs.dto.MessageDTO
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class MessageService(private val db: JdbcTemplate) {
    fun findMessages(): List<MessageDTO> = db.query("select * from messages") { response, _ ->
        MessageDTO(
            response.getString("id"),
            response.getString("text")
        )
    }

    fun save(message: MessageDTO): MessageDTO {
        val id = message.id ?: UUID.randomUUID().toString() // Generate new id if it is null
        db.update(
            "insert into messages values ( ?, ? )",
            id, message.text
        )
        return message.copy(id = id) // Return a copy of the message with the new id
    }
}

// After the SAM conversion, the query function ends up with two arguments: a String at the first position, and a lambda
// expression at the last position. According to the Kotlin convention, if the last parameter of a function is a
// function, then a lambda expression passed as the corresponding argument can be placed outside the parentheses.
// Such syntax is also known as trailing lambda.

// For a lambda with multiple parameters, you can use the underscore _ character to replace the names of the parameters
// you don't use.

// The code message.id ?: UUID.randomUUID().toString() uses the Elvis operator (if-not-null-else shorthand) ?:. If the
// expression to the left of ?: is not null, the Elvis operator returns it; otherwise, it returns the expression to the
// right. Note that the expression on the right-hand side is evaluated only if the left-hand side is null.