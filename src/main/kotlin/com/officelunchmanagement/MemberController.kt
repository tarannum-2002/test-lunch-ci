package com.officelunchmanagement



import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import java.sql.Date


@Controller("/member")
class MemberController {

    @Post
    fun processData(id: Int, name: String, choice: String): HttpResponse<String>{

        return HttpResponse.ok("Success")
    }
}