package classes

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class RecordResponse(
    var id:String,var name:String,var status:String
)
