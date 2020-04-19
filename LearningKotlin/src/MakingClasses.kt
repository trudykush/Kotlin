class KushClass (mName: String, mAge:Int, mNature:Boolean) {

    var name: String? = null
    var age:Int? = null
    var nature:Boolean? = null

    init {
        this.name = mName
        this.age = mAge
        this.nature = mNature
    }

}

fun main(args: Array<String>) {

    var kushClassObject = KushClass("Kush", 28, true)
    println("Let's display: ${kushClassObject.name}")
}