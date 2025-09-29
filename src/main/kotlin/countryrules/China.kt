package nl.joozd.aircraftreg.countryrules

object China: CountryRulesImpl('B') {
    override val ranges = listOf(
        // B-0000 to B-9999
        // B-000A to B-99ZZ (General)[c]
        "B0000" upTo "B9999",
        "B000A" upTo "B99ZZ"
    )

    override val charsBeforeDash = 1
}
