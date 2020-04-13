fun main(args: Array<String>) {
    var myAge:Int = 19

    when(myAge) {
        17 -> println("Hello $myAge")
        19 -> {
            println("First Line")
            println("Hello $myAge")
        }
        else -> {
            println("Nothing Mahn!")
        }
    }
}