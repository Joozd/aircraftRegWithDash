package nl.joozd.aircraftreg.countryrules

internal object DominicanRepublic: CountryRulesImpl('H') {
    override val ranges= listOf(
        "HI100AA" upTo "HI999ZZ",
        "HI100 " upTo "HI100 ",
    )

    /**
     * Dominican Republic doesn't do dashes.
     */
    override fun getCorrectString(stringWithoutDash: String): String =
        stringWithoutDash
}