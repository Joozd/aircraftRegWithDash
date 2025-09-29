package nl.joozd.aircraftreg.countryrules

object Rwanda: CountryRulesImpl('9') {
    override val ranges = listOf(
        "9XRAA" upTo "9XRZZ",
    )

    override val charsBeforeDash = 3
}