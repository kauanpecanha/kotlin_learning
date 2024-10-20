package demodocs.controllers

import demo.services.MessageService
import demodocs.dto.MessageDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/")
class MessageController(
    private val messageService: MessageService,
) {
    @GetMapping("/")
    fun listMessages() = messageService.findMessages()

    @PostMapping
    fun post(@RequestBody message: MessageDTO): ResponseEntity<MessageDTO> {
        val savedMessage = messageService.save(message)
        return ResponseEntity.created(URI("/${savedMessage.id}")).body(savedMessage)
    }
}

// To be able to convert the JSON sent as HTTP Body content into an object, you need to use the @RequestBody annotation
// for the method argument.

// ResponseEntity represents the whole HTTP response: status code, headers, and body.
// Using the created() method you configure the response status code (201) and set the location header indicating the
// context path for the created resource.