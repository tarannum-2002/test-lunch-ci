package com.officelunchmanagement



import classes.EmployeeAttendance
import classes.RecordResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import netscape.javascript.JSObject
import java.sql.Date


@Controller("/member")
class MemberController {

    @Post("/check")
    fun CheckAndReturnRecord(id:String,name: String): RecordResponse {
        val memberAttendance = EmployeeAttendance()
        val (memberId,status)= memberAttendance.returnRecordIfExistsOrSendDefault(id)
        val response = RecordResponse(memberId,status)
        return response
    }

}