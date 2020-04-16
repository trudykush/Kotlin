abstract class GraphicObject {

    fun moveTo(newX: Int, newY: Int) {
        println("Move to $newX and $newY co-ordinates")
    }
     abstract fun shape()
     abstract fun size()
}

class Circle : GraphicObject() {
    override fun shape() {
        println("Circle is the Shape")
    }

    override fun size() {
        println("Circle is medium in size")
    }
}

fun main(args: Array<String>) {
     var circleObject = Circle()
    circleObject.moveTo(4, 6)
    circleObject.shape()
}