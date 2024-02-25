package classes


import jakarta.inject.Singleton

@Singleton
class EmployeeAttendancewithdate {
    var employeeRecords: MutableMap<String, MutableList<PageData>> = mutableMapOf()

    fun insertRecordIfdosentExistOrUpdate(date: String, name: String, status: String, id: String): PageData {

        val newDetails = PageData(id, name, status, date)

        if (!employeeRecords.containsKey(date)) {

            employeeRecords[date] = mutableListOf(newDetails)
        } else {

            val details1 = PageData(id, name, "Yes", date)
            val details2 = PageData(id, name, "No", date)
            val details3 = PageData(id, name, "Not specified", date)

            if (employeeRecords[date]!!.contains(details1)) {
                employeeRecords[date]!!.remove(details1)
            } else if (employeeRecords[date]!!.contains(details2)) {
                employeeRecords[date]!!.remove(details2)
            } else if (employeeRecords[date]!!.contains(details3)) {
                employeeRecords[date]!!.remove(details3)
            }

            employeeRecords[date]!!.add(newDetails)
        }

        return newDetails
    }


    fun checkFordata(date: String, name: String, id: String): PageData {
        val details1 = PageData(id, name, "Yes", date)
        val details2 = PageData(id, name, "No", date)
        if (!employeeRecords.containsKey(date)) {

            employeeRecords[date] = mutableListOf()
        }

        if (employeeRecords[date]!!.contains(details1)) {
            return details1
        } else if (employeeRecords[date]!!.contains(details2)) {
            return details2
        } else {
            return insertRecordIfdosentExistOrUpdate(date, name, "Not specified", id)
        }

    }


    fun getAll(date: String): MutableList<PageData> {


        if (!employeeRecords.containsKey(date)) {
            val temp: MutableList<PageData> = mutableListOf()
            return temp
        } else {
            return employeeRecords[date]!!
        }
    }

}