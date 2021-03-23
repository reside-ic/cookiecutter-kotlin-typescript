package {{ cookiecutter.package }}.controllers

import {{ cookiecutter.package }}.clients.APIClient
import {{ cookiecutter.package }}.models.Response
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class MainController(val apiClient: APIClient) {

    @GetMapping("/random")
    fun random(@RequestParam min: Int, @RequestParam max: Int): Response {
        return Response(Random.nextInt(min, max))
    }

    @GetMapping("/passthrough")
    fun passthrough() = apiClient.ip()
}
