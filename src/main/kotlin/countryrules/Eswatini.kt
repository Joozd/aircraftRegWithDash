package nl.joozd.aircraftreg.countryrules

internal object Eswatini: CountryRulesImpl('Y') {
    override val ranges= listOf("YSAAA" upTo "YSZZZ")

    override val charsBeforeDash: Int = 3
}