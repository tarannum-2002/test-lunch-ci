package classes

import jakarta.inject.Singleton

@Singleton
class EmployeeAttendance {
    private val employeeRecords: MutableMap<String, String> = mutableMapOf()

    fun returnRecordIfExistsOrSendDefault(employeeId: String): Pair<String, String> {
        if (!employeeRecords.containsKey(employeeId)) {
            employeeRecords[employeeId] = "not specified"
        }
        return Pair(employeeId, employeeRecords[employeeId]!!)
    }

    fun insertNewRecord(employeeId: String, status: String): String {
        employeeRecords[employeeId] = status
        return "ok"
    }
}