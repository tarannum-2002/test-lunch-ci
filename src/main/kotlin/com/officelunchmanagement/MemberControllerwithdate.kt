package com.officelunchmanagement


import classes.EmployeeAttendancewithdate
import classes.PageData
import classes.PageData1
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller("/lunchmgmt")
class MemberControllerwithdate(private val memberAttendance: EmployeeAttendancewithdate) {

    @Post("/member/check")
    fun CreateRecord(@Body pageData: PageData1): PageData {
        //val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        //val receivedDate: LocalDate = LocalDate.parse(pageData.date, formatter)
        val response = memberAttendance.checkFordata(pageData.date, pageData.name, pageData.id)

        return response
    }


    @Post("/member/home")
    fun CheckAndReturnRecord(@Body pageData: PageData): PageData {
        val response = memberAttendance.insertRecordIfdosentExistOrUpdate(
            pageData.date,
            pageData.name,
            pageData.status,
            pageData.id
        )

        return response
    }


    @Get("/admin/alldetails")
    // @Consumes(MediaType.TEXT_PLAIN)
    // getting date as a query paramenter, if we want it to be in body change request type to Post
    fun giveAllforday(date: String): MutableList<PageData> {
        return memberAttendance.getAll(date)
    }

    @Get("/admin/coming/count")
    fun giveAllfordaycount(date: String): Int {
        val coming: MutableList<PageData> = mutableListOf()

        for (every in memberAttendance.getAll(date)) {
            if (every.status == "Yes") {
                coming.add(every)
            }
        }

        return coming.size
    }

    @Get("/admin/coming/details")
    fun giveComingAllforday(date: String): MutableList<PageData> {

        val coming: MutableList<PageData> = mutableListOf()

        for (every in memberAttendance.getAll(date)) {
            if (every.status == "Yes") {
                coming.add(every)
            }
        }

        return coming
    }


}