buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.8.10")
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}