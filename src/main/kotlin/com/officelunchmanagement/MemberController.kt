package com.officelunchmanagement



import classes.EmployeeAttendance
import classes.RecordResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import netscape.javascript.JSObject
import java.sql.Date
import kotlin.math.log


@Controller("/member")
class MemberController {

    @Inject
    lateinit var memberAttendance: EmployeeAttendance
    @Post("/addpreference")
    fun addPreference(@Body memberPreference:RecordResponse): HttpResponse<String>? {
        val record = RecordResponse(memberPreference.id,memberPreference.name,memberPreference.status)
        return HttpResponse.ok("Preference Saved Successfully");
    }
    @Post("/check")
    fun CheckAndReturnRecord(id:String,name: String): RecordResponse {
        val (memberId,memberName,status)= memberAttendance.returnRecordIfExistsOrSendDefault(id,name)
        val response = RecordResponse(memberId,memberName,status)
        return response
    }

}