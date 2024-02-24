package com.officelunchmanagement



import classes.EmployeeAttendance
import classes.RecordResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import netscape.javascript.JSObject
import java.sql.Date


@Controller("/member")
class MemberController {

    @Inject
    lateinit var memberAttendance: EmployeeAttendance
    @Post("/check")
    fun CheckAndReturnRecord(id:String,name: String): RecordResponse {
        val (memberId,memberName,status)= memberAttendance.returnRecordIfExistsOrSendDefault(id,name)
        val response = RecordResponse(memberId,memberName,status)
        return response
    }

}