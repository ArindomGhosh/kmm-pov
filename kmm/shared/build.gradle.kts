plugins {
    kotlin("multiplatform")
    id("com.android.library")
//    id("org.jetbrains.compose")
}

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
//                Todo: working on it
//                implementation(compose.runtime)
//                implementation(compose.foundation)
//                implementation(compose.material)
//                implementation(compose.ui)
//                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
//                implementation(compose.components.resources)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
//        @OptIn(org.jetbrains.kotlin.gradle.plugin.ExperimentalKotlinGradlePluginApi::class)
//        invokeWhenCreated("androidDebug"){
//            dependencies{
//                implementation(compose.uiTooling)
//            }
//        }

        val androidMain by getting {
            dependencies {
//                implementation(compose.preview)
//                implementation(libs.androidx.activity.compose)
//                implementation(libs.androidx.core.ktx)
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

android {
    namespace = "com.example.kmmnews.shared"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
//    dependencies {
//        implementation(compose.preview)
//        debugImplementation(compose.uiTooling)
//    }
}
