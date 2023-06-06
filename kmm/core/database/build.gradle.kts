plugins {
    id("com.kmmnews.kotlin.multiplatform.library")
    alias(libs.plugins.sqldelight)
}

kotlin {
    //TODO: https://youtrack.jetbrains.com/issue/KT-41344/Kotlin-Native-several-examples-of-sqlite3-linking-problems
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries {
            findTest(org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType.DEBUG)?.linkerOpts("-lsqlite3")
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.koin.core)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.sqldelight.primitive.adapters)
                implementation(project(":kmm:core:common"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(libs.koin.android)
                implementation(libs.sqldelight.android.driver)
            }
        }
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.sqldelight.native.driver)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

sqldelight {
    databases {
        create("KmmNewsDataBase") {
            packageName.set("com.example.kmmnews.database")
        }
    }
}

android {
    namespace = "com.example.kmmnews.database"
}