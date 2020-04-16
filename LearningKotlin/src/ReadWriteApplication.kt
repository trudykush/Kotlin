import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Paths

fun main (kush: Array<String>) {
    menu()
}

fun menu () {
    println("Press 1 to write, 2 to read and 3 to exit.")
    var inputFromUser = readLine()?.toInt() // instead of !!. I am using ?.
    when(inputFromUser) {
        1 -> {
            println("Please enter your message to write")
            var message = readLine().toString()
            println("Writting..")
            write(message)
        }
        2 -> {
            println("Reading...")
            read()
        } 3 -> {
            println("Exiting...")
        } else -> {
            println("Invalid Entrys.")
        }
    }
}

fun write(message: String) {
    try {
        var writing = FileWriter("KushMessage.txt", false)
        writing.write(message)
        writing.close()
    } catch (e: Exception) {
        println("Exception $e")
    }
}

fun read() {
    var stream = Files.newInputStream(Paths.get("KushMessage.txt"))
    stream.buffered().reader().use {
        reader -> println(reader.readText())
    }
}