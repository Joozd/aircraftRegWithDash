package nl.joozd.aircraftreg.countryrules

object Laos: CountryRulesImpl('R') {
    override val ranges = listOf(
        "RDPL10000" upTo "RDPL99999",
    )

    override val charsBeforeDash = 4
}