plugins {
    id("lib-kotlin-android-no-config")
    id("publish-android")
}

dependencies {
    implementation(libs.common.databinding.runtime)
    api(libs.common.rxjava)
    api(project(":databinding-observables"))

}