import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    id("maven-publish")
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.cio)
            implementation(libs.koin.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
        }

        androidMain.dependencies {

        }

        iosMain.dependencies {
            implementation(libs.ktor.client.ios)
        }
    }
}

android {
    namespace = "sg.rently.shared.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "sg.rently.shared"
            artifactId = "rentlyshared"
            version = "0.0.1"

            from(components["kotlin"])
        }
    }
    repositories {
        maven {
            url = uri("https://your.maven.repo/repository/maven-releases/")
        }
    }
}
