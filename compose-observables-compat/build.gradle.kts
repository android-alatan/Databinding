plugins {
    id("lib-kotlin-android-no-config")
    id("publish-android")
}

android {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    api(libs.compose.runtime)
    api(project(":databinding-observables"))
}