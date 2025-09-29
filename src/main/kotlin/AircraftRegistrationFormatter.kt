package nl.joozd.aircraftreg

import nl.joozd.aircraftreg.countryrules.CountryRules
import nl.joozd.aircraftreg.countryrules.getMap


/**
 * Formats aircraft registration strings according to country-specific rules.
 *
 * It follows the standards from https://en.wikipedia.org/wiki/List_of_aircraft_registration_prefixes
 */
class AircraftRegistrationFormatter internal constructor (val rulesMap: Map<Char, List<CountryRules>>) {
    constructor(): this(getMap())

    /**
     * Format the given registration string into its canonical form.
     */
    fun formatRegistrationString(registrationString: String): String{
        if(registrationString.isBlank()) return ""
        val normalized = registrationString.filter { it.isDigit() || it in 'a'..'z' || it in 'A'..'Z' }

        val applicableRule = rulesMap[normalized.first()]?.firstOrNull { countryRules -> countryRules.isInRange(normalized) }
        if (applicableRule != null) return applicableRule.getCorrectString(normalized)

        return normalized.putDashAtPos2()
    }



    /**
     * Inserts a dash after the first two characters of the string.
     *
     * Used as a fallback when no country-specific formatting rule applies.
     *
     * Examples:
     * - `"PHABC"` → `"PH-ABC"`
     * - `"N12345"` → `"N1-2345"`
     *
     * If the string length is 2 or less, returns the original string unchanged.
     */
    private fun String.putDashAtPos2(): String {
        if (length <= 2) return this
        return take(2) + "-" + drop(2)
    }
}