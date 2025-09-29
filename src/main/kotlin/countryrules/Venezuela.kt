package nl.joozd.aircraftreg.countryrules

internal object Venezuela: CountryRulesImpl('Y') {
    override val ranges = listOf(
        "YV1000" upTo "YV9999",
        "YV100T" upTo "YV999T",
        "YV100E" upTo "YV999E",
        "YVO100" upTo "YVO999"
    )

    /**
     * Venezuela doesn't do dashes.
     */
    override fun getCorrectString(stringWithoutDash: String): String =
        stringWithoutDash
}
