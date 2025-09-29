package nl.joozd.aircraftreg.countryrules

internal object Italy: CountryRulesImpl('I') {
    override val ranges = listOf(
        "IAAAA" upTo "IZZZZ"
    )

    override val charsBeforeDash = 1
}
