package nl.joozd.aircraftreg.countryrules

object Unitedkingdom: CountryRulesImpl('G') {
    override val ranges = listOf(
        "GAAAA" upTo "GZZZZ"
    )

    override val charsBeforeDash = 1
}
