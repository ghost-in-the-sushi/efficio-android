object Versions {
    const val androidGradle = "3.4.0"
    const val kotlin = "1.3.31"
    const val navigation = "2.1.0-alpha02"
}

object Libs {
    const val appCompat = "androidx.appcompat:appcompat:1.0.2"
    const val androidGradle = "com.android.tools.build:gradle:${Versions.androidGradle}"
    const val core = "androidx.core:core-ktx:1.1.0-alpha05"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    const val kotlinJdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui:${Versions.navigation}"
    const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
}

object TestLibs {
    const val junit = "junit:junit:4.12"
}

object AndroidTestLibs {
    const val testRunner = "androidx.test:runner:1.1.0-alpha4"
    const val espressoCore = "androidx.test.espresso:espresso-core:3.1.0-alpha4"
}