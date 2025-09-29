package nl.joozd.aircraftreg.countryrules

object Italy: CountryRulesImpl('I') {
    override val ranges = listOf(
        "IAAAA" upTo "IZZZZ"
    )
}
