class Outer {
    var mString = "Outer Class Variable"

    inner class InnerNested() {
        var innerString  = "Inner Nested Class String"

        fun gettingOuterVariable() = mString

        fun InnerNestedClassFunction() = "This is inner nested class function"
    }
}

fun main (args: Array<String>) {
    var outer = Outer()

    println("Accessing Outer variable : ${outer.InnerNested().gettingOuterVariable()}")

    // or
    var innerObject = Outer().InnerNested()
    println("Another way: ${innerObject.gettingOuterVariable()}")

    println("Inner Function message is: ${outer.InnerNested().InnerNestedClassFunction()}")
}