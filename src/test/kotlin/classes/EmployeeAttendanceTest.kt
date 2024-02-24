package classes

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class EmployeeAttendanceTest {

    private val employeeAttendance = EmployeeAttendance()
    @Test
    fun `return id and not specified as status if the record is absent`() {
        val record = employeeAttendance.returnRecordIfExistsOrSendDefault("1a","selva")
        if(record!=null) {
            assertEquals("1a", record.id)
            assertEquals("selva", record.name)
            assertEquals("not specified", record.status)
        }
    }

    @Test
    fun `insert a record and check if the record is actually inserted`() {
        val record = MemberPreference("2","Vishwa","yes")
        employeeAttendance.insertNewRecord(record)
        val savedRecord = employeeAttendance.returnRecordIfExistsOrSendDefault(record.id,record.name)
        if(savedRecord!=null) {
            assertEquals("2", savedRecord.id)
            assertEquals("yes", savedRecord.status)
        }
    }
}