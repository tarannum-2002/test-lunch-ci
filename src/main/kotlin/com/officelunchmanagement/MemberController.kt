package com.officelunchmanagement



import classes.EmployeeAttendance
import classes.MemberPreference
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import jakarta.inject.Inject


@Controller("/member")
class MemberController {

    @Inject
    var memberAttendance= EmployeeAttendance()
    @Post("/addpreference")
    fun addPreference(@Body memberPreference:MemberPreference): HttpResponse<String>? {
        val record = MemberPreference(memberPreference.id,memberPreference.name,memberPreference.status)
        memberAttendance.insertNewRecord(record)
        return HttpResponse.ok("Preference Saved Successfully");
    }

    @Post("/check")
    fun CheckAndReturnRecord(id: String,name:String): MemberPreference? {
        val record = memberAttendance.returnRecordIfExistsOrSendDefault(id,name)
        return record
    }

}