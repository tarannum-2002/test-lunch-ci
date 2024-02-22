package com.officelunchmanagement



import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import java.sql.Date

//@Controller("/member")
//class HelloController {
//
//    @Get
//    @Produces(MediaType.TEXT_PLAIN)
//    fun index() = "Hello World"
//}

//enum class status{
//    YES, NO
//}


//data class MyData(val name: String)
//
@Controller("/member")
class MyController {

    @Post
    fun processData(id: Int, name: String, choice: String): HttpResponse<String>{

        return HttpResponse.ok("Success")
    }
}