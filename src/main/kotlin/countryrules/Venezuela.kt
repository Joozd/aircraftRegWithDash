package nl.joozd.aircraftreg.countryrules

object Venezuela: CountryRulesImpl('Y') {
    override val ranges = listOf(
        "YV1000" upTo "YV9999",
        "YV100T" upTo "YV999T",
        "YV100E" upTo "YV999E",
        "YVO100" upTo "YVO999"
    )
}
