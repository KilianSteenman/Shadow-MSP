import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.compose.compose

buildscript {
    repositories { mavenCentral() }
    dependencies { classpath(kotlin("gradle-plugin", "1.4.32")) }
}

plugins {
    id("org.jetbrains.intellij") version "0.4.10"
    kotlin("jvm") version "1.4.32"
    id("org.jetbrains.compose") version "0.4.0-build182"
}

group = "nl.shadowlink.mission"
version = "0.1"

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
    maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.32")

    implementation("com.github.KilianSteenman:Shadow-MSC:0.3.2-alpha")
    implementation("org.ini4j", "ini4j", "0.5.4")
    implementation("com.google.code.gson", "gson", "2.8.6")

    // Compose
    implementation("org.jetbrains.compose.material:material:")
    implementation(compose.desktop.currentOs)

    testImplementation("junit", "junit", "4.12")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version = "2019.2.3"
}
configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.getByName<org.jetbrains.intellij.tasks.PatchPluginXmlTask>("patchPluginXml") {
    changeNotes(
        """
      Add change notes here.<br>
      <em>most HTML tags may be used</em>"""
    )
}
tasks.withType<KotlinCompile>().all {
    kotlinOptions.jvmTarget = "1.8"
}