import java.io.FileWriter

fun main(kush: Array<String>) {

    println("PLease enter something to enter in the file")
    var message = readLine().toString()
    if (message.equals("")) {
        println("Please enter a message")
    } else {
        writeToFile(message)
    }
}

fun writeToFile(message: String) {

    try {
        var messageToWrite = FileWriter("KushMessage.txt", true)
        messageToWrite.write(message + "\n")
        messageToWrite.close()
    } catch (e: Exception) {
        println("Exception is $e")
    }
}