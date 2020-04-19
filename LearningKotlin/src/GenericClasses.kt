
class GTypeClass<T> (userName: T, password: T) {
    init {
        println("Username = $userName, Password = $password")
    }
}

class Human(name: String, password: String) {
    var userName: String? = null
    var password: String? = null
    init {
        this.userName = name
        this.password = password
        println("Person Class printed")
    }
}


fun main (args: Array<String>) {

    var login = GTypeClass<String>("Kush", "kushPassword")

    var humanObject = Human("Kushal", "password for Kush");

    var person = GTypeClass<Human>(humanObject, humanObject)
}