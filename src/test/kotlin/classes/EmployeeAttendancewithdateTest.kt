package classes


import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*


class EmployeeAttendancewithdateTest {


    private val employeeAttendancewithdate = EmployeeAttendancewithdate()

    @Test
    fun `data is stored correctly`(){
        val sendingData = PageData("1","abc","yes","24/02,2024")

        employeeAttendancewithdate.insertRecordIfdosentExistOrUpdate(sendingData.date,sendingData.name,sendingData.status,sendingData.id)

        assertEquals(sendingData.id, employeeAttendancewithdate.employeeRecords[sendingData.date]!![0].id)
        assertEquals(sendingData.name, employeeAttendancewithdate.employeeRecords[sendingData.date]!![0].name)
        assertEquals(sendingData.date, employeeAttendancewithdate.employeeRecords[sendingData.date]!![0].date)
        assertEquals(sendingData.status, employeeAttendancewithdate.employeeRecords[sendingData.date]!![0].status)
    }

    @Test
    fun `data is getting updated correctly`(){
        var sendingData = PageData("1","abc","Yes","24/02,2024")
        employeeAttendancewithdate.insertRecordIfdosentExistOrUpdate(sendingData.date,sendingData.name,sendingData.status,sendingData.id)

         sendingData = PageData("1","abc","No","24/02,2024")
        employeeAttendancewithdate.insertRecordIfdosentExistOrUpdate(sendingData.date,sendingData.name,sendingData.status,sendingData.id)

        assertEquals(sendingData.id, employeeAttendancewithdate.employeeRecords[sendingData.date]!![0].id)
        assertEquals(sendingData.name, employeeAttendancewithdate.employeeRecords[sendingData.date]!![0].name)
        assertEquals(sendingData.date, employeeAttendancewithdate.employeeRecords[sendingData.date]!![0].date)
        assertEquals(sendingData.status, employeeAttendancewithdate.employeeRecords[sendingData.date]!![0].status)
    }

    @Test
    fun `on a particular date we are able to fetch all details`(){

        var sendingData = PageData("2","abcd","Yes","24/02,2024")
        employeeAttendancewithdate.insertRecordIfdosentExistOrUpdate(sendingData.date,sendingData.name,sendingData.status,sendingData.id)
        //first entry of that day
        assertEquals(sendingData.id, employeeAttendancewithdate.employeeRecords[sendingData.date]!![0].id)
        assertEquals(sendingData.name, employeeAttendancewithdate.employeeRecords[sendingData.date]!![0].name)
        assertEquals(sendingData.date, employeeAttendancewithdate.employeeRecords[sendingData.date]!![0].date)
        assertEquals(sendingData.status, employeeAttendancewithdate.employeeRecords[sendingData.date]!![0].status)

         sendingData = PageData("1","abc","Yes","24/02,2024")
        employeeAttendancewithdate.insertRecordIfdosentExistOrUpdate(sendingData.date,sendingData.name,sendingData.status,sendingData.id)
        sendingData = PageData("1","abc","No","24/02,2024")

        //second entry of that day
        employeeAttendancewithdate.insertRecordIfdosentExistOrUpdate(sendingData.date,sendingData.name,sendingData.status,sendingData.id)
        assertEquals(sendingData.id, employeeAttendancewithdate.employeeRecords[sendingData.date]!![1].id)
        assertEquals(sendingData.name, employeeAttendancewithdate.employeeRecords[sendingData.date]!![1].name)
        assertEquals(sendingData.date, employeeAttendancewithdate.employeeRecords[sendingData.date]!![1].date)
        assertEquals(sendingData.status, employeeAttendancewithdate.employeeRecords[sendingData.date]!![1].status)
    }

}