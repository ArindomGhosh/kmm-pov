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
}