package nl.joozd.aircraftreg.countryrules

object Unitedstates: CountryRulesImpl('N') {
    /**
     * true if [stringWithoutDash] falls under these rules.
     * This includes partial strings, e.g. "ZAA" should be in "ZAAAA"-"ZAZZZ"
     */
    override fun isInRange(stringWithoutDash: String): Boolean =
        stringWithoutDash.startsWith("N")

    /**
     * USA doesn't do dashes. Also, no leading zeroes in numbers.
     */
    override fun getCorrectString(stringWithoutDash: String): String{
        val digits = stringWithoutDash.filter { it.isDigit() }
        if(digits !in stringWithoutDash) return stringWithoutDash // all digits must be in one group, this is an invalid registration
        val shortenedDigits = digits.toInt().toString()
        return stringWithoutDash.replace(digits, shortenedDigits)
    }

}
