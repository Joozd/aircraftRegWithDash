package nl.joozd.aircraftreg.countryrules

object Guernsey: CountryRulesImpl('2') {
    override val ranges = listOf(
        // B-0000 to B-9999
        // B-000A to B-99ZZ (General)[c]
        "2AAAA" upTo "2ZZZZ",
    )

    override val charsBeforeDash = 1
}