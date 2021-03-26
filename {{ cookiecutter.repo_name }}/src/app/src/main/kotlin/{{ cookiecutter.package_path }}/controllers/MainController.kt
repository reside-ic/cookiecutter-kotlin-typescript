package {{ cookiecutter.package }}.controllers

import net.logstash.logback.argument.StructuredArguments.kv
import {{ cookiecutter.package }}.clients.APIClient
import {{ cookiecutter.package }}.models.Response
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class MainController(val apiClient: APIClient) {

    val logger: Logger = LoggerFactory.getLogger(javaClass)

    @GetMapping("/random")
    fun random(@RequestParam min: Int, @RequestParam max: Int): Response {
        logger.info("random {} {}", kv("min", min), kv("max", max))
        return Response(Random.nextInt(min, max))
    }

    @GetMapping("/passthrough")
    fun passthrough() = apiClient.ip()
}
