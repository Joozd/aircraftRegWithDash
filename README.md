Module aircraftRegWithDash

# AircraftRegistrationFormatter

This module puts the dash in the correct position in an aircraft registration
string, following country-specific rules.

## Overview

Many countries assign aircraft registrations with a prefix (indicating the
country of registration) and a suffix (unique within that country). The dash
between prefix and suffix is mandatory, but user input often comes without it.
This module normalizes such registrations by:

* Cleaning the input string (keeping only digits and letters).
* Looking up the correct formatting rule for the registration prefix.
* Inserting the dash at the correct position based on those rules.
* Falling back to a simple `XX-YYY` style (dash after two characters) if
  no country-specific rule matches.

## Key Components

- **`CountryRules` / `CountryRulesImpl`**  
  Define the valid ranges and dash placement for each country.

- **`AircraftRegistrationFormatter`**  
  Main entry point for normalizing registrations.  
  Takes a map of country rules and applies them when formatting.

## Usage Example

```kotlin
val formatter = AircraftRegistrationFormatter()

println(formatter.formatRegistrationString("PHKLM"))
// → "PH-KLM"

println(formatter.formatRegistrationString("7TVAA"))
// → "7T-VAA"
```

## Changelog

#### 1.0 
Initial version

#### 1.0.1
Bugfix - no more USA crashing on registrations without digits
Marked all internal parts as internal
