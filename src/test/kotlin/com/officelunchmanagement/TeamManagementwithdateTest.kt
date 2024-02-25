package com.officelunchmanagement

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import jakarta.inject.Inject
import io.restassured.specification.RequestSpecification
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.`is`

@MicronautTest
class TeamManagementwithdateTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>




    @Inject
    lateinit var embeddedServer: EmbeddedServer

    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }


    @Test
    fun `memberhomepage endpoint should return the member record when a body of member is passed`(specification: RequestSpecification) {
        val requestBody = "{\"id\":\"1a\",\"name\":\"selva\",\"status\":\"Yes\",\"date\":\"24/02/2024\"}"
        val responseBody = "{\"id\":\"1a\",\"name\":\"selva\",\"status\":\"Yes\",\"date\":\"24/02/2024\"}"
        specification.contentType("application/json").body(requestBody).`when`().post("/lunchmgmt/memberhome").then()
            .assertThat().body(`is`(responseBody))
    }


    @Test
    fun `admin endpoint in members should return the member record when a body of member is passed`(specification: RequestSpecification) {
        val dateQueryParam = "24/02/2024" // date as a query parameter
        val responseBody = "1"
        specification.param("date", dateQueryParam)
            .contentType("text/plain")
            .`when`()
            .get("/lunchmgmt/admin")
            .then()
            .assertThat()
            .body(equalTo(responseBody))


    }




}