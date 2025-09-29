package nl.joozd.aircraftreg.countryrules

internal object Germany: CountryRulesImpl('D') {
    override val ranges = listOf(
        "DAAAA" upTo "DZZZZ"
    )
}
