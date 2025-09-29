package nl.joozd.aircraftreg.countryrules

// Includes French Overseas
internal object France: CountryRulesImpl('F') {
    override val ranges = listOf(
        "FAAAA" upTo "FZZZZ"
    )

    override val charsBeforeDash = 1
}
