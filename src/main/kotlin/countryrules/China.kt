package nl.joozd.aircraftreg.countryrules

object China: CountryRulesImpl('B') {
    override val ranges = listOf(
        "B0000" upTo "B9999",
        "B000A" upTo "B99ZZ"
    )
}
