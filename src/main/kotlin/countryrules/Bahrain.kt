package nl.joozd.aircraftreg.countryrules

object Bahrain: CountryRulesImpl('A') {
    override val ranges = listOf(
        "A9CAA" upTo "A9CZZ",
        "A9CAAA" upTo "A9CZZZ",
        "A9CAAAA" upTo "A9CZZZZ"
    )
}
