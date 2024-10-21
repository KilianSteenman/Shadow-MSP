import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", "2.0.0"))
        classpath(kotlin("serialization", "2.0.0"))
    }
}

plugins {
    id("org.jetbrains.intellij") version "1.17.4"
    id("org.jetbrains.kotlin.jvm") version "2.0.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.0"
}

repositories {
    mavenCentral()
    google()
    maven(url = "https://jitpack.io")
}

group = "nl.shadowlink.mission"
version = "0.1"

// Include the generated files in the source set
sourceSets {
    main {
        java {
            srcDirs("src/main/gen")
        }
    }
}

dependencies {
    implementation("com.github.KilianSteenman:Shadow-MSC:0.3.2-alpha")
    implementation("org.ini4j", "ini4j", "0.5.4")
    implementation("com.google.code.gson", "gson", "2.8.6")

    // XML Parsing
    implementation("io.github.pdvrieze.xmlutil:core:0.90.2")
    implementation("io.github.pdvrieze.xmlutil:serialization-jvm:0.90.1")

    testImplementation(kotlin("test"))
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version.set("2023.3")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

tasks {
    buildSearchableOptions {
        enabled = false
    }

    patchPluginXml {
        version.set("${project.version}")
        sinceBuild.set("233")
        untilBuild.set("241.*")
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "17"
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = "17"
    }

    test {
        useJUnitPlatform()
    }
}