fun main(args: Array<String>) {

    var myArray = Array<Int>(5){2}
    myArray[0] = 34
    myArray[1] = 23
    myArray[2] = 26

    for (element in myArray) {
       // println("element are $element in ${myArray[2]}")
    }

    for (index in myArray.indices) {    // 0..myArray.size - 1
//        println(myArray[index])
    }

    var arrayList = ArrayList<String>()
    arrayList.add("Kush")
    arrayList.add("Superman")
    arrayList.add("batman")
    arrayList.add(1, "SpiderMan")
    arrayList.set(0, "All SuperHeros")  //arrayList[0] = "All Superman"

    for (elements in arrayList) {
        println(elements)
    }

    if (arrayList.contains("batman")) {         // case-sensitive
        println("I am Batman")
        arrayList.remove("Superman")    // case-sensitive
    }

    for (elements in arrayList) {
        println(elements)
    }

    for (index in arrayList.indices) {
        println("Printing list by indexes ${arrayList.get(index)}")
    }

}