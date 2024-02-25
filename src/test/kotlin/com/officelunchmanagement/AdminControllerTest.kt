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

        val request: HttpRequest<Any> = HttpRequest.GET("/admin/count")
        val response: HttpResponse<Map<String, Map<String, MemberPreference>>> = client.toBlocking()
            .exchange(request)

        assertEquals(200, response.status.code)

    }

    @Test
    fun `check if you get response count as 0 if employee attendance has No entry`() {
        val client = HttpClient.create(embeddedServer.url)
        val request: HttpRequest<Any> = HttpRequest.GET("/admin/count")
        val response = client.toBlocking().exchange(request, Map::class.java)
        assertEquals(0, response.body()["count"])
    }

    @Test
    fun `check if you get response count as 0 if employee attendance has no entry with Yes`() {
        val client = HttpClient.create(embeddedServer.url)
        val memberInfo = MemberPreference("1", "Vishwa", "No")
        val addMemberPreferencerequest = HttpRequest.POST("/member/addpreference", memberInfo)
        client.toBlocking().exchange(addMemberPreferencerequest, String::class.java)
        val request: HttpRequest<Any> = HttpRequest.GET("/admin/count")
        val response = client.toBlocking().exchange(request, Map::class.java)
        assertEquals(0, response.body()["count"])
    }

    @Test
    fun `check if you get response count as 1 if employee attendance has 1 entry with Yes`() {
        val client = HttpClient.create(embeddedServer.url)
        val memberInfo = MemberPreference("1", "Vishwa", "Yes")
        val addMemberPreferencerequest = HttpRequest.POST("/member/addpreference", memberInfo)
        client.toBlocking().exchange(addMemberPreferencerequest, String::class.java)
        val request: HttpRequest<Any> = HttpRequest.GET("/admin/count")
        val response = client.toBlocking().exchange(request, Map::class.java)
        assertEquals(1, response.body()["count"])
    }

    @Test
    fun `check if you get response count as 1 if employee attendance has only 1 entry with Yes`() {
        val client = HttpClient.create(embeddedServer.url)
        val memberInfo = listOf( MemberPreference("1", "Vishwa", "Yes"),
            MemberPreference("2", "Tarunam", "No"))

        memberInfo.forEach {
            val addMemberPreferencerequest = HttpRequest.POST("/member/addpreference", it)
            client.toBlocking().exchange(addMemberPreferencerequest, String::class.java)
        }
        val request: HttpRequest<Any> = HttpRequest.GET("/admin/count")
        val response = client.toBlocking().exchange(request, Map::class.java)
        assertEquals(1, response.body()["count"])
    }


}

