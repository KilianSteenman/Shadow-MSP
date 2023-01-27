import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.compose.compose

buildscript {
    repositories { mavenCentral() }
    dependencies { classpath(kotlin("gradle-plugin", "1.7.20")) }
}

plugins {
    id("org.jetbrains.intellij") version "1.10.2"
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
    id("org.jetbrains.compose") version "1.2.1"
}

repositories {
    mavenCentral()
    maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven(url = "https://jitpack.io")
}

group = "nl.shadowlink.mission"
version = "0.1"

dependencies {
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
    version.set("2022.1.4")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
}

tasks {
    buildSearchableOptions {
        enabled = false
    }

    patchPluginXml {
        version.set("${project.version}")
        sinceBuild.set("221")
        untilBuild.set("223.*")
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
}