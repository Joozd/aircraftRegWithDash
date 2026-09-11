plugins {
    kotlin("jvm") version "2.2.10"
    id("maven-publish")
    id("org.jetbrains.dokka") version "2.0.0"
}

val versionName = "1.0.1"
val groupID = "nl.joozd.aircraftreg"

group = groupID
version = versionName

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

val sourceJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.named("main").map { it.allSource })
}

/**
 * Dokka v2 — central configuration.
 */
dokka {
    moduleName.set("aircraftRegWithDash")

    dokkaPublications.html {
        outputDirectory.set(layout.buildDirectory.dir("docs"))
        // failOnWarning.set(true)
        // suppressInheritedMembers.set(true)
    }

    dokkaPublications.findByName("javadoc")?.apply {
        outputDirectory.set(layout.buildDirectory.dir("javadoc"))
    }

    dokkaSourceSets.main {
        includes.from("README.md")

        jdkVersion.set(17)

        sourceLink {
            localDirectory.set(file("src/main/kotlin"))
            remoteUrl("https://github.com/Joozd/aircraftRegWithDash/tree/master/src/main/kotlin")
            remoteLineSuffix.set("#L")
        }

        // reportUndocumented.set(true)
        // documentedVisibilities(VisibilityModifier.Public)
    }

    // pluginsConfiguration.html {
    //     customAssets.from("docs/logo.png")
    //     customStyleSheets.from("docs/styles.css")
    // }
}

/**
 * Package Dokka outputs as JARs.
 */
val dokkaGenerate = tasks.named("dokkaGenerate")

val dokkaHtmlJar by tasks.registering(Jar::class) {
    dependsOn(dokkaGenerate)
    archiveClassifier.set("html-docs")
    from(layout.buildDirectory.dir("docs"))
}

val dokkaJavadocJar by tasks.registering(Jar::class) {
    dependsOn(dokkaGenerate)
    archiveClassifier.set("javadoc")
    from(layout.buildDirectory.dir("javadoc"))
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            groupId = groupID
            artifactId = "aircraftreg"
            version = versionName

            artifact(sourceJar.get())
            artifact(dokkaHtmlJar.get())

            if (plugins.hasPlugin("org.jetbrains.dokka-javadoc")) {
                artifact(dokkaJavadocJar.get())
            }

            pom {
                name.set("Aircraft Registration Formatter")
                description.set("Formats Aircraft Registrations correctly")
                url.set("https://github.com/Joozd/aircraftRegWithDash")

                licenses {
                    license {
                        name.set("Apache License 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0")
                        distribution.set("repo")
                    }
                }
            }
        }
    }

    repositories {
        maven {
            val isSnapshot = version.toString().endsWith("-SNAPSHOT")

            name = "reposilite"

            url = uri(
                if (isSnapshot) {
                    "https://repo.joozd.nl/snapshots"
                } else {
                    "https://repo.joozd.nl/releases"
                }
            )

            credentials {
                username = findProperty("repoUsername")?.toString()
                    ?: error("Missing Gradle property: repoUsername")

                password = findProperty("repoPassword")?.toString()
                    ?: error("Missing Gradle property: repoPassword")
            }
        }
    }
}