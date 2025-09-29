// src/test/kotlin/…/AircraftRegistrationFormatterIntegrationTest.kt
import nl.joozd.aircraftreg.AircraftRegistrationFormatter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AircraftRegistrationFormatterIntegrationTest {

    private val f = AircraftRegistrationFormatter() // uses getMap()

    // --- Europe ---

    @Test
    fun `Netherlands PH- prefix is dashed after PH`() {
        // Wikipedia: NL uses PH- + suffix
        // https://en.wikipedia.org/wiki/List_of_aircraft_registration_prefixes
        assertEquals("PH-KLM", f.formatRegistrationString("phklm"))
        assertEquals("PH-ABC", f.formatRegistrationString("  PH abc "))
    }

    @Test
    fun `United Kingdom G- prefix dashed after G`() {
        // UK uses G- followed by 4 letters (examples like G-BOAC appear widely)
        // https://en.wikipedia.org/wiki/United_Kingdom_aircraft_registration
        assertEquals("G-BOAC", f.formatRegistrationString("gboac"))
        assertEquals("G-ABCD", f.formatRegistrationString("G-ABCD"))
    }

    @Test
    fun `Germany D- prefix dashed after D`() {
        // Germany uses D- plus four letters (e.g., D-ABCD)
        // https://knowledgebase.vatsim-germany.org/.../german-aircraft-registration
        assertEquals("D-ABCD", f.formatRegistrationString("d abcd"))
        assertEquals("D-IBIS", f.formatRegistrationString("DIBIS"))
    }

    @Test
    fun `France F- prefix dashed after F`() {
        // France uses F- + suffix (e.g., F-GSQN)
        // https://en.wikipedia.org/wiki/List_of_aircraft_registration_prefixes
        assertEquals("F-GSQN", f.formatRegistrationString("fgsqn"))
        assertEquals("F-HABC", f.formatRegistrationString("F HABC"))
    }

    // --- Africa / Middle East ---

    @Test
    fun `Algeria 7T- prefix dashed after 7T`() {
        // Algeria uses 7T- + suffix
        // https://en.wikipedia.org/wiki/List_of_aircraft_registration_prefixes
        assertEquals("7T-VAA", f.formatRegistrationString("7tvaa"))
        assertEquals("7T-ABC", f.formatRegistrationString("  7T abc "))
    }

    // --- North America ---

    @Test
    fun `United States N numbers keep no dash and follow FAA patterns`() {
        println("wut?")
        // FAA patterns: N + (1–5 digits) OR digits+letters (I and O not used)
        // https://www.faa.gov/licenses_certificates/aircraft_certification/aircraft_registry/forming_nnumber
        assertEquals("N12345", f.formatRegistrationString("n-12345"))
        assertEquals("N123AB", f.formatRegistrationString(" N 123ab "))
        assertEquals("N1",     f.formatRegistrationString("n001"))     // leading zeros stripped by normalization logic if present
    }

    // --- Normalization & fallbacks still behave with real rules ---

    @Test
    fun `mixed whitespace and punctuation are stripped before applying real rules`() {
        assertEquals("PH-KLM", f.formatRegistrationString("  P-H  K_L M "))
        assertEquals("G-TEST", f.formatRegistrationString(" g . t e s t "))
    }

    @Test
    fun `unknown prefix falls back to dash after two characters`() {
        // If a prefix is not in getMap(), fallback is XX-...
        assertEquals("AB-CD",   f.formatRegistrationString("ab-cd"))
        assertEquals("AB",      f.formatRegistrationString("ab")) // <= 2 chars unchanged
    }

    @Test
    fun `Zimbabwe Z- prefix is dashed after Z`() {
        // Zimbabwe uses Z- followed by up to four letters
        // https://en.wikipedia.org/wiki/List_of_aircraft_registration_prefixes
        assertEquals("Z-ZTEST", f.formatRegistrationString("zztest"))
    }
}
