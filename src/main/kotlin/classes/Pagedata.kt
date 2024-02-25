package classes

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class PageData(
    var id: String,
    var name: String,
    var status:String,
    var date: String
)
