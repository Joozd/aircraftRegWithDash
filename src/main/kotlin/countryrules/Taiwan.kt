package nl.joozd.aircraftreg.countryrules

object Taiwan: CountryRulesImpl('B') {
    override val ranges = listOf(
        "B00000" upTo "B99999"
    )
}
