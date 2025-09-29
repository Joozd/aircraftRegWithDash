package nl.joozd.aircraftreg.countryrules

internal object Unitedkingdom: CountryRulesImpl('G') {
    override val ranges = listOf(
        "GAAAA" upTo "GZZZZ"
    )

    override val charsBeforeDash = 1
}
