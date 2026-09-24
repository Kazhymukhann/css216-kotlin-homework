package hw2.task04

fun main() {
    val firstSong = Song("Morning Code", "Demo Artist", 2026, 999)
    val secondSong = Song("Evening Build", "Demo Artist", 2026, 1000)
    firstSong.printDescription()
    println("Popular: ${firstSong.isPopular}")
    secondSong.printDescription()
    println("Popular: ${secondSong.isPopular}")
}

class Song(val title: String, val artist: String, val yearPublished: Int, val playCount: Int) {
    val isPopular: Boolean
        get() = playCount >= 1000

    fun printDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}
