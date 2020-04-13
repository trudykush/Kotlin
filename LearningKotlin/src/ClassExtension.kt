fun String.removeFirstAndLastChar(): String {
    return this.substring(1, this.length - 2)
}

fun main (args: Array<String>) {
    var name = "xKushal"
    var resultName = name.removeFirstAndLastChar()
    println(resultName)
}