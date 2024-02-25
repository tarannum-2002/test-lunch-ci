package com.officelunchmanagement

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.restassured.specification.RequestSpecification
import jakarta.inject.Inject
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

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
        val requestBody = "{\"id\":\"3a\",\"name\":\"selva\"}"
        val responseBody = "{\"id\":\"3a\",\"name\":\"selva\",\"status\":\"not specified\"}"
        specification.contentType("application/json").body(requestBody).`when`().post("/member/check").then()
            .assertThat().body(`is`(responseBody))
    }
    @Test
    fun `check endpoint should return the success message when a record is saved`(specification: RequestSpecification) {
        val requestBody = "{\"id\":\"1a\",\"name\":\"selva\",\"status\":\"yes\"}"
        val responseBody = "Preference Saved Successfully"
        specification.contentType("application/json").body(requestBody).`when`().post("/member/addpreference").then()
            .assertThat().body(`is`(responseBody))
    }

}
