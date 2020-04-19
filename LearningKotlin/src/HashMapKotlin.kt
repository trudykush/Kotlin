fun main(args: Array<String>) {
    /*
    *   HashMap -> Key, Value pair
    * */
    var hashMap = HashMap<String, String>()
    hashMap.put("Kush", "Smart")
    hashMap.put("Others", "verySmart")

    for (k in hashMap.keys) {
        println("All values in hashmap are ${hashMap.get(k)}")
    }
}