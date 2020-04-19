enum class SUITS {
    HEARTS,
    SPADES,
    DIAMOND,
    CLUB
}

fun main (args: Array<String>) {

    var card = SUITS.DIAMOND

    if (card == SUITS.DIAMOND) {
        print("Shine like a diamond!!")
    }
}