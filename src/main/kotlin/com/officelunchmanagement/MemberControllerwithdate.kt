package com.officelunchmanagement


import classes.EmployeeAttendancewithdate
import classes.EmployeeAttendance
import classes.PageData
import classes.RecordResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import jakarta.inject.Inject
import netscape.javascript.JSObject
import java.sql.Date
import java.time.LocalDate
import java.time.format.DateTimeFormatter

//@PathVariable id: String
@Controller("/members")
class MemberControllerwithdate {

    @Inject
    lateinit var memberAttendance: EmployeeAttendancewithdate
    @Post
    fun CheckAndReturnRecord(@Body pageData: PageData): PageData {
        //val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        //val receivedDate: LocalDate = LocalDate.parse(pageData.date, formatter)
        val response = memberAttendance.insertRecordIfdosentExistOrUpdate(pageData.date,pageData.name,pageData.status,pageData.id)

        return response
    }


    @Post("/all")
    fun giveAllforday(@Body pageData: PageData): MutableList<PageData> {
        //val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        //val receivedDate: LocalDate = LocalDate.parse(pageData.date, formatter)
        val response = memberAttendance.insertRecordIfdosentExistOrUpdate(pageData.date,pageData.name,pageData.status,pageData.id)

        return memberAttendance.getAll(pageData.date)
    }




}