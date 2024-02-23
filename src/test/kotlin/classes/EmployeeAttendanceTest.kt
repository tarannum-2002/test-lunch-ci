package classes

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class EmployeeAttendanceTest {

    private val employeeAttendance = EmployeeAttendance()
    @Test
    fun `return id and not specified as status if the record is absent`() {
        val (id,status) = employeeAttendance.returnRecordIfExistsOrSendDefault("1a")

        assertEquals("1a",id)
        assertEquals("not specified",status)
    }

    @Test
    fun `insert a record and check if the record is actually inserted`() {
        val response = employeeAttendance.insertNewRecord("1b","yes")
        val (id,status) = employeeAttendance.returnRecordIfExistsOrSendDefault("1b")

        assertEquals("1b",id)
        assertEquals("yes",status)
    }
}