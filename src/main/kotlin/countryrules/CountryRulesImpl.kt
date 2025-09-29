package nl.joozd.aircraftreg.countryrules

/**
 * Implement this to get auto-added to CountryRules.rulesMap
 */
abstract class CountryRulesImpl(firstLetter: Char): CountryRules{
    init{
        val listsWithThisLetter = CountryRules.rulesMap.getOrPut(firstLetter) { mutableListOf() }
        listsWithThisLetter.add(this)
    }

    abstract val ranges: List<ForgivingRange>

    /**
     * true if [stringWithoutDash] falls under these rules.
     * This includes partial strings, e.g. "ZAA" should be in "ZAAAA"-"ZAZZZ"
     */
    override fun isInRange(stringWithoutDash: String): Boolean{
        val upperCased = stringWithoutDash.uppercase()
        return ranges.any{ range -> upperCased in range }
    }

    /**
     * This is the most used implementation: 2 characters, dash, the rest.
     * For other implementations: override this function
     */
    override fun getCorrectString(stringWithoutDash: String): String =
        if(stringWithoutDash.length <= 2) stringWithoutDash
        else stringWithoutDash.take(2) + "-" + stringWithoutDash.drop(2)
}