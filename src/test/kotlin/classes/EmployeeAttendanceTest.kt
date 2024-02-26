package classes

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class EmployeeAttendanceTest {

    private val employeeAttendance = EmployeeAttendance()
    @Test
    fun `return id and not specified as status if the record is absent`() {
        val (id,name,status) = employeeAttendance.returnRecordIfExistsOrSendDefault("1a","Vishwa")

        assertEquals("1a",id)
        assertEquals("Vishwa",name)
        assertEquals("not specified",status)
    }

    @Test
    fun `insert a record and check if the record is actually inserted`() {
        val response = employeeAttendance.insertNewRecord("1b","viswa","yes")
        val (id,name,status) = employeeAttendance.returnRecordIfExistsOrSendDefault("1b","viswa")

        assertEquals("1b",id)
        assertEquals("yes",status)
        assertEquals("ok",response)
    }
}