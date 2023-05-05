plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
}

android {
    namespace = "com.example.kmmnews.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.example.kmmnews.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(project(":kmm:shared"))
    implementation(libs.androidx.activity.compose)
    implementation(compose.foundation)
    implementation(compose.ui)
    debugImplementation(compose.uiTooling)
    implementation(compose.preview)
    implementation(compose.material)
}