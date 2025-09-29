package nl.joozd.aircraftreg.countryrules

object Canada: CountryRulesImpl('C') {
    override val ranges = listOf(
        "CFAAA" upTo "CFZZZ",
        "CFAAA" upTo "CFZZZ",
        "CGAAA" upTo "CGZZZ",
        "CIAAA" upTo "CIZZZ"
    )
}
