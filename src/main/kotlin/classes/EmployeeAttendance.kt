package classes

import jakarta.inject.Singleton

@Singleton
class EmployeeAttendance {
    private val employeeRecords: MutableMap<String, MemberPreference> = mutableMapOf()

    fun returnRecordIfExistsOrSendDefault(employeeId: String,name:String): MemberPreference? {
        if (!employeeRecords.containsKey(employeeId)) {
            val responseRecord=MemberPreference(employeeId,name,"not specified")
            employeeRecords[employeeId]=responseRecord
        }
        return employeeRecords[employeeId]
    }

    fun insertNewRecord(memberPreference: MemberPreference): String {
        employeeRecords[memberPreference.id] = memberPreference
        return "ok"
    }

    fun getEmployeeRecords(): MutableMap<String, MemberPreference>{
        return employeeRecords
    }
}