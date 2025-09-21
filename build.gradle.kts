

plugins {
    kotlin("jvm") version "2.1.20"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.insert-koin:koin-core:3.5.3")
    testImplementation("io.insert-koin:koin-test:3.5.3")
}

application {
    mainClass.set("org.example.MainKt")
}


tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}