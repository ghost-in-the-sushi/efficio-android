plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id(Plugins.safeArgs)
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
    implementation(Libs.kotlinCoroutines)
    implementation(Libs.appCompat)
    implementation(Libs.core)
    implementation(Libs.constraintLayout)
    implementation(Libs.koin)
    implementation(Libs.lifecycleExtensions)
    implementation(Libs.lifecycleViewModel)
    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUi)
    implementation(Libs.retrofit)
    implementation(Libs.retrofitCoroutinesAdapter)
    implementation(Libs.retrofitMoshiConverter)
    implementation(Libs.room)
    implementation(Libs.roomKtx)

    kapt(Libs.roomCompiler)

    testImplementation(TestLibs.junit)

    androidTestImplementation(AndroidTestLibs.testRunner)
    androidTestImplementation(AndroidTestLibs.espressoCore)
}
