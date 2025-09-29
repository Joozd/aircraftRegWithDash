package nl.joozd.aircraftreg.countryrules

internal object Zimbabwe: CountryRulesImpl('Z') {
    override val ranges = listOf(
        "ZAAAA" upTo "ZZZZZ"
    )

    override val charsBeforeDash = 1
}
