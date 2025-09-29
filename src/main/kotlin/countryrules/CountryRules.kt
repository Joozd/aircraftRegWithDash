package nl.joozd.aircraftreg.countryrules

internal interface CountryRules {
    /**
     * true if [stringWithoutDash] falls under these rules.
     * This should include partial strings, e.g. "ZAA" should be in "ZAAAA"-"ZAZZZ"
     */
    fun isInRange(stringWithoutDash: String): Boolean

    /**
     * Returns the string with the Hyphen in the correct place.
     * It can assume the String is according to its rules.
     */
    fun getCorrectString(stringWithoutDash: String): String

    companion object{
        val rulesMap = HashMap<Char, MutableList<CountryRules>>()
    }

    infix fun String.upTo(other: String): ForgivingRange = ForgivingRange(this, other)
}