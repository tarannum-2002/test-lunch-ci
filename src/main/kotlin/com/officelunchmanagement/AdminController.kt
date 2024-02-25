package com.officelunchmanagement

import classes.EmployeeAttendance
import classes.MemberPreference
//import classes.RecordResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject




@Controller("/admin")
class AdminController{

    @Inject
    var memberAttendance = EmployeeAttendance()

    @Post("/count")
    fun getCount(): MutableHttpResponse<Map<String, MutableMap<String, MemberPreference>>>? {
        val count = memberAttendance.getEmployeeRecords()
        val response = mapOf("count" to count)
        return HttpResponse.ok(response)
    }
}