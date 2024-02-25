package com.officelunchmanagement

//import classes.RecordResponse
import classes.EmployeeAttendance
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
    fun getCount(): MutableHttpResponse<Map<String, Int>>? {
        var count = 0

        val members = memberAttendance.getEmployeeRecords()
        for (memberPreference in members.values) {
            if (memberPreference.status == "Yes") {
                count++
            }
        }

        val response = mapOf("count" to count)
        return HttpResponse.ok(response)
    }
}