plugins {
    id("lib-kotlin-android-no-config")
    id("publish-android")
}

android {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
}

dependencies {
    api(libs.compose.runtime)
    api(project(":databinding-observables"))
}