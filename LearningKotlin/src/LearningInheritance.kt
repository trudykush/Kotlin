open class Animal() {

    var name:String? = null
    var color:String? = null

    constructor(name: String, color:String): this() {
        this.name = name
        this.color = color
    }
}

class Lion(): Animal() {

}

fun main(args: Array<String>) {
    var lion = Lion()
    lion.name = "Kush"
    println("Name of Lion is: ${lion.name}")
}