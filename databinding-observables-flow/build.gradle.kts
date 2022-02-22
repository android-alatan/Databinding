plugins {
    id("lib-kotlin-android-no-config")
    id("publish-android")
}

dependencies {
    api(libs.common.coroutine)
    api(project(":databinding-observables"))

    testImplementation(project(":coroutine-test-util"))
}