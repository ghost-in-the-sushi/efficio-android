import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath(Libs.androidGradle)
        classpath(Libs.kotlinGradlePlugin)
        classpath(Libs.safeArgs)
    }
}

plugins {
    id(Plugins.ktlintGradle) version Versions.ktlintGradle
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

subprojects {
    apply(plugin = Plugins.ktlintGradle)
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}

ktlint {
    android.set(true)
    version.set("0.32.0")
    verbose.set(true)
    outputToConsole.set(true)
    coloredOutput.set(true)
    reporters.set(setOf(ReporterType.CHECKSTYLE, ReporterType.JSON))
}