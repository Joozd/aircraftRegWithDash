package nl.joozd.aircraftreg.countryrules

object France: CountryRulesImpl('F') {
    override val ranges = listOf(
        "FAAAA" upTo "FZZZZ"
    )
}
