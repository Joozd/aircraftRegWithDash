package nl.joozd.aircraftreg.countryrules

/**
 * Check if a String is in a range. If the string is shorter, the strings to check again are made shorter too.
 * I    f it is longer, it's cut off at the check length.
 */
internal class ForgivingRange(val start: String, val end: String) {
    init{
        require(start.length == end.length)
    }
    val length = start.length

    operator fun contains(s: String): Boolean{
        if (s.length == length) return s in start..end
        if (s.length > length) return s.take(length) in start..end
        val l = s.length
        return s in start.take(l)..end.take(l)
    }
}