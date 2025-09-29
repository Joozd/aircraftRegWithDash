package nl.joozd.aircraftreg.countryrules

object Southkorea: CountryRulesImpl('H') {
    override val ranges = listOf(
        "HL0000" upTo "HL9999",
    )

    /**
     * S-Korea doesn't do dashes.
     */
    override fun getCorrectString(stringWithoutDash: String): String =
        stringWithoutDash
}