package com.officelunchmanagement

import classes.EmployeeAttendance
import classes.RecordResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject


@Inject
lateinit var memberAttendance: EmployeeAttendance

@Controller("/admin")
class AdminController{

    @Post("/count")
    fun getCount(): HttpResponse<Map<String, Int>> {
        val count = 10
        val response = mapOf("count" to count)
        return HttpResponse.ok(response)
    }
}