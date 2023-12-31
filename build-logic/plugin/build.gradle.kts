/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Gradle plugin project to get you started.
 * For more details take a look at the Writing Custom Plugins chapter in the Gradle
 * User Manual available at https://docs.gradle.org/8.1.1/userguide/custom_plugins.html
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    `kotlin-dsl`
}
group = "com.example.kmmnews.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("kmmAndroidLibrary"){
            id="com.kmmnews.android.library"
            implementationClass ="AndroidLibraryConvention"
        }
        register("kmmAndroidApplication"){
            id="com.kmmnews.android.application"
            implementationClass ="AndroidApplicationConvention"
        }
        register("kmmJetpackCompose"){
            id="com.kmmnews.android.application.compose"
            implementationClass="AndroidComposeApplicationConvention"
        }
        register("kotlinMultiplatform"){
            id="com.kmmnews.kotlin.multiplatform"
            implementationClass ="KotlinMultiplatformConvention"
        }
        register("kotlinMultiplatformLibrary"){
            id="com.kmmnews.kotlin.multiplatform.library"
            implementationClass ="KotlinMultiplatformLibraryConvention"
        }
    }
}
