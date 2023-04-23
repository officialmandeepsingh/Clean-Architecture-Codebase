// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
    }
    dependencies {
        val nav_version = "2.5.3"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}
plugins {
    id("com.android.application") version "8.1.0-beta01" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id("com.android.library") version "7.4.2" apply false
//    kotlin("kapt") version "1.8.20"
//    id ("com.google.dagger.hilt.android") version "2.45" apply false
}