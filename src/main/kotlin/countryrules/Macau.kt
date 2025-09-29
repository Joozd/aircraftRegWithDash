package nl.joozd.aircraftreg.countryrules

object Macau: CountryRulesImpl('B') {
    override val ranges = listOf(
        "BMAA" upTo "BMZZ"
    )

    override val charsBeforeDash = 1
}
