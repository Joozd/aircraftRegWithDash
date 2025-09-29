package nl.joozd.aircraftreg.countryrules

object Zimbabwe: CountryRulesImpl('Z') {
    override val ranges = listOf(
        "ZAAAA" upTo "ZZZZZ"
    )
}
