package nl.joozd.aircraftreg.countryrules

object Oman: CountryRulesImpl('A') {
    override val ranges = listOf(
        "A4OAA" upTo "A4OZZ",
        "A4OAAA" upTo "A4OZZZ"
    )

    override val charsBeforeDash = 3
}
