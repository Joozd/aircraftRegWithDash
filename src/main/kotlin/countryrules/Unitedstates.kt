package nl.joozd.aircraftreg.countryrules

object Unitedstates: CountryRulesImpl('N') {
    override val ranges = listOf(
        "N1" upTo "N99999",
        "N1A" upTo "N9999Z",
        "N1AA" upTo "N999ZZ"
    )
}
