plugins {
    id("java")
    id("net.neoforged.moddev") version "2.0.140"
}

group = "de.petrofsky"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    exclusiveContent {
        forRepository {
            maven("https://www.cursemaven.com") { name = "CurseMaven" }
        }
        filter { includeGroup("curse.maven") }
    }
    exclusiveContent {
        forRepository {
            maven("https://api.modrinth.com/maven") { name = "Modrinth" }
        }
        filter { includeGroup("maven.modrinth") }
    }
}

dependencies {
    implementation("maven.modrinth:kzF5itx6:Shd5Tlv5")
    // Electrodynamics 1.0.11 (CurseMaven)
    implementation("curse.maven:electrodynamics-316867:8400288")
    // Nuclear Science 0.8.6 (CurseMaven)
    implementation("curse.maven:nuclear-science-318646:8400297")
    testImplementation(platform("org.junit:junit-bom:6.0.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

val mod_id = property("mod_id") as String

neoForge {
    version = "21.1.219"

    validateAccessTransformers = true

    runs {
        register("client") {
            client()
        }
        register("data") {
            data()
        }
        register("server") {
            server()
        }
    }

    mods {
        create(mod_id) {
            sourceSet(sourceSets.main.get())
        }
    }
}