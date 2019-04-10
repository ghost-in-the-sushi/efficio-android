plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "org.ghostinthesuhi.android.efficio"
        minSdkVersion(21)
        targetSdkVersion(28)

        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(Libs.kotlinJdk)
    implementation(Libs.appCompat)
    implementation(Libs.core)
    implementation(Libs.constraintLayout)

    testImplementation(TestLibs.junit)

    androidTestImplementation(AndroidTestLibs.testRunner)
    androidTestImplementation(AndroidTestLibs.espressoCore)
}
