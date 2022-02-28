plugins {
    id("lib-kotlin-android-no-config")
    kotlin("kapt")
    id("publish-android")
}

android {
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    api(libs.common.databinding.runtime)
}