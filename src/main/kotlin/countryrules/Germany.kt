package nl.joozd.aircraftreg.countryrules

object Germany: CountryRulesImpl('D') {
    override val ranges = listOf(
        "DAAAA" upTo "DZZZZ"
    )
}
