object Versions {
    const val androidGradle = "3.3.2"
    const val kotlin = "1.3.21"
}

object AndroidX {
}

object Libs {
    const val appCompat = "androidx.appcompat:appcompat:1.0.0-beta01"
    const val androidGradle = "com.android.tools.build:gradle:${Versions.androidGradle}"
    const val core = "androidx.core:core-ktx:1.1.0-alpha05"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
    const val kotlinJdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object TestLibs {
    const val junit = "junit:junit:4.12"
}

object AndroidTestLibs {
    const val testRunner = "androidx.test:runner:1.1.0-alpha4"
    const val espressoCore = "androidx.test.espresso:espresso-core:3.1.0-alpha4"
}