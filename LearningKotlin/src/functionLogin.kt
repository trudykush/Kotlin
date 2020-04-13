
var sumOfTwoNumbers:Int? = 0
fun main(args: Array<String>) {
    sumOfTwoNumbers = add(2,3)
    println("Sum of two numbers is : $sumOfTwoNumbers")

    sub(10, 6)

    println("My Name is ${getName("Kush")}")
}

fun add(firstNumber: Int, secondNumber:Int): Int {
    var sum = firstNumber + secondNumber
    return sum
}

fun sub(x: Int, y: Int) :Unit {
    println("Substraction is : ${x-y}")
}

fun getName(name: String) : String {
    return name
}