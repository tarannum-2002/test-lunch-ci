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
        val response = memberAttendance.insertRecordIfdosentExistOrUpdate(
            pageData.date,
            pageData.name,
            pageData.status,
            pageData.id
        )

        return response
    }


    @Post("/memberhome")
    fun CheckAndReturnRecord(@Body pageData: PageData): PageData {
        //val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        //val receivedDate: LocalDate = LocalDate.parse(pageData.date, formatter)
        val response = memberAttendance.insertRecordIfdosentExistOrUpdate(
            pageData.date,
            pageData.name,
            pageData.status,
            pageData.id
        )

        return response
    }


    @Get("/admin/details")
    // @Consumes(MediaType.TEXT_PLAIN)
    // getting date as a query paramenter, if we want it to be in body chnge ewquest type to Post
    fun giveAllforday(date: String): MutableList<PageData> {
        //val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        //val receivedDate: LocalDate = LocalDate.parse(pageData.date, formatter)
        return memberAttendance.getAll(date)
    }

    @Get("/admin")
    //@Consumes(MediaType.TEXT_PLAIN)
    // getting date as a query paramenter, if we want it to be in body chnge ewquest type to Post
    fun giveAllfordaycount(date: String): Int {
        //val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        //val receivedDate: LocalDate = LocalDate.parse(pageData.date, formatter)

        return memberAttendance.getAll(date).size
    }


}