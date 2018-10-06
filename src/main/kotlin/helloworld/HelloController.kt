package helloworld

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue

@Controller("/")
class HelloController {

    @Get("/hello/{name}")
    fun hello(@QueryValue greeting:String, name:String): String {
        return "$greeting $name"
    }
    @Get("/index")
    fun index(): String {
        return "bla"
    }
}