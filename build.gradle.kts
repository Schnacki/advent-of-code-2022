plugins {
    kotlin("jvm") version "1.7.10"
    application
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("AppKt")
}
