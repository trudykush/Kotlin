interface UIActivity {
    fun clicked()
}

class PhoneBook : UIActivity {
    override fun clicked() {
        println("Phone book clicked")
    }
}

fun main(args: Array<String>) {
    var phoneBookClicked  = PhoneBook()
    phoneBookClicked.clicked()
}