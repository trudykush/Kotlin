import java.io.FileReader
import java.io.FileWriter
import java.nio.file.Files
import java.nio.file.Paths

fun main(kush: Array<String>) {

    //readFromFile()
    readFileKotlinStyle()
}

fun readFromFile() {
    var reader = FileReader("KushMessage.txt")
    var readMessage: String? = null
    var char: Int? = null

    try {
        do {
            char = reader.read()
            print(char.toChar())
        } while (char != -1)
    } catch (e: Exception) {
    }
}

fun readFileKotlinStyle() {
    val stream = Files.newInputStream(Paths.get("KushMessage.txt"))
    stream.buffered().reader().use {
        reader -> println(reader.readText())
    }
}