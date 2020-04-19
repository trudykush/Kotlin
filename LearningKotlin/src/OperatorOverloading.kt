fun main(args: Array<String>) {
    var a = 3
    var b = 5

    val point1 = Point(10, -4)
    val point2 = Point(3, 8)

    var sum = point1 + point2
    println("The sum = (${sum.x}, ${sum.y})")

    var minus = point1 - point2
    println("The minus = (${minus.x}, ${minus.y})")
}

class Point (val x: Int = 0, val y: Int = 1) {

    operator fun plus(p: Point) : Point {
        return Point(x + p.x, y + p.y)
    }

    operator fun minus(p: Point): Point {
        return Point(x - p.x, y - p.y)
    }
}