package nl.joozd.aircraftreg.countryrules

internal object JapanDigits: CountryRulesImpl('J') {
    override val ranges = listOf(
        // B-0000 to B-9999
        // B-000A to B-99ZZ (General)[c]
        "JA0000" upTo "JA9999",
        "JA001A" upTo "JA999Z",
        "JA01AA" upTo "JA99ZZ",
        "JAA001" upTo "JAA999",
    )

    /**
     * Japan with digits doesn't do dashes.
     */
    override fun getCorrectString(stringWithoutDash: String): String =
        stringWithoutDash
}