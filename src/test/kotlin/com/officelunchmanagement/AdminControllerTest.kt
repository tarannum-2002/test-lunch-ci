package com.officelunchmanagement



import classes.EmployeeAttendance
import classes.MemberPreference
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


@MicronautTest
class AdminControllerTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    lateinit var embeddedServer: EmbeddedServer


    @Inject
    lateinit var memberAttendance: EmployeeAttendance


    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }

    @Test
    fun `check if you get response are 200 on hitting the count url`() {
        val client = HttpClient.create(embeddedServer.url)

        val request: HttpRequest<Any> = HttpRequest.POST("/admin/count", "")
        val response: HttpResponse<Map<String, Map<String, MemberPreference>>> = client.toBlocking()
            .exchange(request)

        assertEquals(200, response.status.code)

    }


}

