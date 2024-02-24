package classes

import jakarta.inject.Singleton

@Singleton
class EmployeeAttendance {
    private val employeeRecords: MutableMap<Pair<String,String>, String> = mutableMapOf()

    fun returnRecordIfExistsOrSendDefault(employeeId: String,employeeName: String): Triple<String, String, String> {
        if (!employeeRecords.containsKey(Pair(employeeId,employeeName))) {
            employeeRecords[Pair(employeeId,employeeName)] = "not specified"
        }
        return Triple(employeeId, employeeName,employeeRecords[Pair(employeeId,employeeName)]!!)
    }

    fun insertNewRecord(employeeId: String, employeeName: String, status: String): String {
        employeeRecords[Pair(employeeId,employeeName)] = status
        return "ok"
    }
}