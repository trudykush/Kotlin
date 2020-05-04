package databases.model

import java.text.DateFormat
import java.util.*

class ChoreModel() {
    var choreName: String? = null
    var assignTo: String? = null
    var assignBy: String? = null
    var timeAssigned: Long? = null
    var id: Int? = null

    constructor(choreName: String?, assignTo: String?, assignBy: String?,
                timeAssigned: Long?, id: Int? ): this() {
        this.choreName = choreName
        this.assignTo = assignTo
        this.assignBy = assignBy
        this.timeAssigned = timeAssigned
        this.id = id
    }


    fun showHumanDate(timeAssigned: Long): String {

        var dateFormat: java.text.DateFormat = DateFormat.getDateInstance()
        var formattedDate: String = dateFormat.format(Date(timeAssigned).time)

        return "Created: ${formattedDate}"

    }

    override fun toString(): String {
        return "Chore(choreName=$choreName, assignedBy=$assignBy, assignedTo=$assignTo, timeAssigned=$timeAssigned, id=$id)"
    }


}