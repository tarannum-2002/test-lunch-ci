package com.officelunchmanagement



import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import jakarta.inject.Inject
import io.restassured.specification.RequestSpecification
import org.hamcrest.CoreMatchers.`is`

@MicronautTest
class AdminControllerTest  {

    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Test
    fun testItWorks() {
        Assertions.assertTrue(application.isRunning)
    }

    @Test
    fun `check endpoint should return the employee record when a body of member id and name is sent`(specification: RequestSpecification) {

        val responseBody = "{\"count\":10}"
        specification.contentType("application/json").`when`().post("/admin/count").then()
            .assertThat().body(`is`(responseBody))
    }

}

