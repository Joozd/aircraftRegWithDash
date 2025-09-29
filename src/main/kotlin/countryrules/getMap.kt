package nl.joozd.aircraftreg.countryrules

private val allCountriesList = listOf(
    Bahrain,
    Canada,
    China,
    DominicanRepublic,
    Eswatini,
    France,
    Germany,
    Guernsey,
    Hongkong,
    Isleofman,
    Italy,
    JapanDigits,
    Laos,
    Macau,
    Northkorea,
    Oman,
    Rwanda,
    Southkorea,
    Taiwan,
    Unitedkingdom,
    Unitedstates,
    Uzbekistan,
    Venezuela,
    Zimbabwe
)

internal fun getMap(): Map<Char, List<CountryRules>>{
    allCountriesList // create all objects so map gets filled
    return CountryRules.rulesMap
}