// src/test/kotlin/…/AircraftRegistrationFormatterTest.kt
import nl.joozd.aircraftreg.AircraftRegistrationFormatter
import nl.joozd.aircraftreg.countryrules.CountryRules
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

private class FakeRule(
    private val predicate: (String) -> Boolean,
    private val format: (String) -> String
) : CountryRules {
    override fun isInRange(stringWithoutDash: String) = predicate(stringWithoutDash)
    override fun getCorrectString(stringWithoutDash: String) = format(stringWithoutDash)
}

class AircraftRegistrationFormatterTest {

    // Helper to build the SUT with custom rules
    private fun formatter(vararg entries: Pair<Char, List<CountryRules>>) =
        AircraftRegistrationFormatter(mapOf(*entries))

    @Test
    fun `blank input yields empty string`() {
        val f = formatter()
        assertEquals("", f.formatRegistrationString(""))
        assertEquals("", f.formatRegistrationString("   "))
        assertEquals("", f.formatRegistrationString("\n\t"))
    }

    @Test
    fun `non-alphanumeric characters are stripped before matching and formatting`() {
        // For prefix 'P', accept PHxxx and format to PH-XXX (uppercase)
        val ruleP = FakeRule(
            predicate = { it.startsWith("PH") && it.length >= 3 },
            format = { norm -> "PH-" + norm.drop(2).uppercase() }
        )
        val f = formatter('P' to listOf(ruleP))

        // Input has spaces and a dash; should normalize to "PHKLM" before rule applies.
        assertEquals("PH-KLM", f.formatRegistrationString("  P H - K L M  "))
        // Lowercase input also normalizes; rule formats to uppercase suffix.
        assertEquals("PH-ABC", f.formatRegistrationString("phabc"))
    }

    @Test
    fun `uses only rules bucket for first character`() {
        val ruleP = FakeRule(predicate = { true }, format = { "PH-KLM" })
        val ruleX = FakeRule(predicate = { true }, format = { "XX-IGNORED" })

        // Map has rules for 'P' and 'X', but input starts with 'P' → only 'P' list is considered
        val f = formatter('P' to listOf(ruleP), 'X' to listOf(ruleX))

        assertEquals("PH-KLM", f.formatRegistrationString("PHKLM"))
    }

    @Test
    fun `first matching rule in list is used`() {
        val nonMatching = FakeRule(predicate = { false }, format = { "NOPE" })
        val matching = FakeRule(predicate = { it.startsWith("PH") }, format = { "PH-" + it.drop(2) })
        val laterMatching = FakeRule(predicate = { true }, format = { "SHOULD-NOT-HIT" })

        val f = formatter('P' to listOf(nonMatching, matching, laterMatching))

        assertEquals("PH-KLM", f.formatRegistrationString("PHKLM"))
    }

    @Test
    fun `falls back to dash at position 2 when no rule matches`() {
        val nonMatching = FakeRule(predicate = { false }, format = { "NOPE" })
        val f = formatter('A' to listOf(nonMatching))

        assertEquals("AB-CD", f.formatRegistrationString("ABCD"))
        assertEquals("AB-C", f.formatRegistrationString("ABC"))
        assertEquals("AB", f.formatRegistrationString("AB-")) // '-' removed before fallback; result becomes "AB"
        assertEquals("AB", f.formatRegistrationString("AB"))   // length ≤ 2 → unchanged
    }

    @Test
    fun `falls back when there is no rules bucket for first character`() {
        val f = formatter(/* empty map */)

        assertEquals("PH-KLM", f.formatRegistrationString("PHKLM"))
        assertEquals("7T-VAA", f.formatRegistrationString("7TVAA"))
        assertEquals("AB-CD12", f.formatRegistrationString("ABCD12"))
    }

    @Test
    fun `numbers are preserved during normalization`() {
        val f = formatter()
        assertEquals("AB-12C3", f.formatRegistrationString("AB-12 C3"))
    }
}
