package com.example.kmmnews

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*,*,*,*>
){
    val libs=extensions.getByType(VersionCatalogsExtension::class).named("libs")
    commonExtension.apply {
        compileSdk=libs.findVersion("compileSdk").get().toString().toInt()
        defaultConfig{
            minSdk=libs.findVersion("minSdk").get().toString().toInt()
        }
        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
    }
}

internal fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}