package nl.joozd.aircraftreg.countryrules

internal object Isleofman: CountryRulesImpl('M') {
    override val ranges = listOf(
        "MAAAA" upTo "MZZZZ"
    )
    override val charsBeforeDash = 1
}
