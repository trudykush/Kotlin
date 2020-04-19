fun main(args: Array<String>) {

    var name:String?    // ? says you will initialize it later
    name = "Kush"

    var myChar = 'K'
    println(myChar)

    var myExplicitChar:Char?
    myExplicitChar = 'M'
    println(myExplicitChar)

    println("$myChar $myExplicitChar")

    var age:Int = 28
    println("$name is $age")

    var myDouble:Double?
    myDouble = 23.5
    println("Double number is $myDouble")

    var myFloatImplicitly = 34.5
    println("Implicitly declaring float number $myFloatImplicitly")

    var myFloat:Float?
    myFloat = 34.5f //F or f
    println("Float number is $myFloat")

    val PI = 3.14
    println(PI)

    println("What is your name?")
    var response = readLine()
    println("Hullo $response")

}