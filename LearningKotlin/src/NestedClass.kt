class OuterClass {
    var mString = "Outside class"

    class NestedClass {
        var mNestedString = "Nested Class"
        fun nestedClassFunction() = "Inside Nested Class function invoked"
    }
}


fun main (args: Array<String>) {
    println(OuterClass.NestedClass().mNestedString)
    var nestedClassObject = OuterClass.NestedClass()

    println()

    println(nestedClassObject.nestedClassFunction())
}