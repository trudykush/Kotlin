fun main(args: Array<String>) {

    // By default list are immutable
    var arrayListKotlin = listOf<String>("Hullo", "Kush", "Hi")
    println(arrayListKotlin)
    // or
    var arrayListGeneric = listOf(0, "Fordo", "TheRing", true)
    println(arrayListGeneric)

    // Mutual list are like
    var mutableList = mutableListOf("Kush", true, "is", "mutuable", 7)
    println(mutableList)
    mutableList[1] = false
    println(mutableList)

    // Kotlin style HashMap
    var kotlinHashMap = hashMapOf(1 to "Kush", 2 to true, 3 to 32, 4 to "Kotlin")
    println(kotlinHashMap)
    for (elements in kotlinHashMap.keys) {
        println("ALl elements of Kotlin is: ${kotlinHashMap.get(elements)}")
    }

    // Kotlin Style Arrays
    var kotlinArray = arrayOf(1, "Kush", 3, true)
    for(items in kotlinArray) {
        println("ELements in Kotlin Style Array is: $items")
    }
}