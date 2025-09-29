package nl.joozd.aircraftreg.countryrules

internal object Laos: CountryRulesImpl('R') {
    override val ranges = listOf(
        "RDPL10000" upTo "RDPL99999",
    )

    override val charsBeforeDash = 4
}