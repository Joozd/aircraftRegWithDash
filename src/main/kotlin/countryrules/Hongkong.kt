package nl.joozd.aircraftreg.countryrules

internal object Hongkong: CountryRulesImpl('B') {
    override val ranges = listOf(
        // B-0000 to B-9999
        // B-000A to B-99ZZ (General)[c]
        "BHAA" upTo "BHZZ",
        "BKAA" upTo "BKZZ",
        "BLAA" upTo "BLZZ",
    )

    override val charsBeforeDash = 1
}