package nl.joozd.aircraftreg.countryrules

object Uzbekistan: CountryRulesImpl('U') {
    override val ranges = listOf(
        "UK10000" upTo "UK99999"
    )

    /**
     * Uzbekistan doesn't do dashes.
     */
    override fun getCorrectString(stringWithoutDash: String): String =
        stringWithoutDash
}
