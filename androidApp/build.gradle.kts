plugins {
    id("com.kmmnews.android.application.compose")
}

android {
    namespace = "com.example.kmmnews.android"
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
}

dependencies {
    implementation(compose.foundation)
    implementation(compose.ui)
    debugImplementation(compose.uiTooling)
    implementation(compose.preview)
    implementation(compose.material)
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
    implementation("androidx.navigation:navigation-compose:2.5.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
}