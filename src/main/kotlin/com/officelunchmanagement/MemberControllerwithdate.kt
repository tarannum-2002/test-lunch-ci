package com.officelunchmanagement


import classes.EmployeeAttendancewithdate
import classes.PageData
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller("/lunchmgmt")
class MemberControllerwithdate(private val memberAttendance: EmployeeAttendancewithdate) {

    @Post("/memberlogin")
    fun CreateRecord(@Body pageData: PageData): PageData {
        //val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        //val receivedDate: LocalDate = LocalDate.parse(pageData.date, formatter)
        val response = memberAttendance.insertRecordIfdosentExistOrUpdate(pageData.date,pageData.name,pageData.status,pageData.id)

        return response
    }






    @Post("/memberhome")
    fun CheckAndReturnRecord(@Body pageData: PageData): PageData {
        //val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        //val receivedDate: LocalDate = LocalDate.parse(pageData.date, formatter)
        val response = memberAttendance.insertRecordIfdosentExistOrUpdate(pageData.date,pageData.name,pageData.status,pageData.id)

        return response
    }


    @Get("/admin")
    @Consumes(MediaType.TEXT_PLAIN)
    fun giveAllforday(@Body date: String): MutableList<PageData> {
        //val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        //val receivedDate: LocalDate = LocalDate.parse(pageData.date, formatter)
       // val response = memberAttendance.insertRecordIfdosentExistOrUpdate(pageData.date,pageData.name,pageData.status,pageData.id)
       // println(pageData.date)
        return memberAttendance.getAll(date)
    }

    @Get("/admin/count")
    @Consumes(MediaType.TEXT_PLAIN)
    fun giveAllfordaycount(@Body date:String): Int{
        //val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        //val receivedDate: LocalDate = LocalDate.parse(pageData.date, formatter)
        //val response = memberAttendance.insertRecordIfdosentExistOrUpdate(pageData.date,pageData.name,pageData.status,pageData.id)
      //println(date)
        return memberAttendance.getAll(date).size
    }




}