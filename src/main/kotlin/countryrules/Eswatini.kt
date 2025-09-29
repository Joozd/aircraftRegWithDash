package nl.joozd.aircraftreg.countryrules

object Eswatini: CountryRulesImpl('Y') {
    override val ranges= listOf("YSAAA" upTo "YSZZZ")

    override val charsBeforeDash: Int = 3
}