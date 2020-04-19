fun main(args: Array<String>) {

    for (item in 1..5) {
        println("Kush $item")
    }

    println();

    for (item in 1..20) {
        if (item % 2 == 0) {
            println("Mutilple of $item")
        }
    }
}