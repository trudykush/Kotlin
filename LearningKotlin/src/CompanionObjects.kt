class Person {

    companion object Name { // giving name to companion object is completely optional
        var name = "Kush"
        fun getName() = println("Admin Name is $name")
    }
}

fun main (args: Array<String>) {
    Person.getName()
}