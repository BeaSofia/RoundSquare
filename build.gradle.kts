import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
    application
}

group = "me.utilizador"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    flatDir { dirs("libs") }
}

dependencies {
    testImplementation(kotlin("test-junit"))
    implementation("pt.isel:CanvasLib-jvm:1.0.1")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"}
