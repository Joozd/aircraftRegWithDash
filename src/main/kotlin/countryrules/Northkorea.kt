package nl.joozd.aircraftreg.countryrules

internal object Northkorea: CountryRulesImpl('P') {
    override val ranges = listOf(
        "P500" upTo "P999",
    )

    override val charsBeforeDash = 1
}