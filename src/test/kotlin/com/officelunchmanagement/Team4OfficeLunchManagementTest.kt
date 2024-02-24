package com.officelunchmanagement

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import jakarta.inject.Inject
import io.restassured.specification.RequestSpecification
import org.hamcrest.CoreMatchers.`is`

@MicronautTest
class Team4OfficeLunchManagementTest {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }

    @Test
    fun `check endpoint should return the employee record when a body of member id and name is sent`(specification: RequestSpecification) {
        val requestBody = "{\"id\":\"1a\",\"name\":\"selva\"}"
        val responseBody = "{\"id\":\"1a\",\"name\":\"selva\",\"status\":\"not specified\"}"
        specification.contentType("application/json").body(requestBody).`when`().post("/member/check").then()
            .assertThat().body(`is`(responseBody))
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
        val requestBody = "24/02/2024"
        val responseBody = "0"
        specification.contentType("text/plain").body(requestBody).`when`().get("/lunchmgmt/admin/count").then()
            .assertThat().body(`is`(responseBody))
    }

}
