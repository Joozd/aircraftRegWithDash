package nl.joozd.aircraftreg.countryrules

object Isleofman: CountryRulesImpl('M') {
    override val ranges = listOf(
        "MAAAA" upTo "MZZZZ"
    )
}
