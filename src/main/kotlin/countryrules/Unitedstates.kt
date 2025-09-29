package nl.joozd.aircraftreg.countryrules

object Unitedstates: CountryRulesImpl('N') {
    /**
     * true if [stringWithoutDash] falls under these rules.
     * This includes partial strings, e.g. "ZAA" should be in "ZAAAA"-"ZAZZZ"
     */
    override fun isInRange(stringWithoutDash: String): Boolean =
        stringWithoutDash.startsWith("N")

    /**
     * USA doesn't do dashes.
     */
    override fun getCorrectString(stringWithoutDash: String): String =
        stringWithoutDash
}
