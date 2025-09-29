package nl.joozd.aircraftreg.countryrules

internal object Canada: CountryRulesImpl('C') {
    // C-FAAA to C-FZZZ
    // CF-AAA to CF-ZZZ (Pre-1957 vintage aircraft may be registered CF- instead of C-F, but we ignore that)
    // C-GAAA to C-GZZZ
    // C-IAAA to C-IZZZ (ultralight airplanes only)
    override val ranges = listOf(
        "CFAAA" upTo "CFZZZ",
        "CFAAA" upTo "CFZZZ",
        "CGAAA" upTo "CGZZZ",
        "CIAAA" upTo "CIZZZ"
    )

    override val charsBeforeDash = 1
}
