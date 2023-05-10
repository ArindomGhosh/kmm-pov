package com.example.kmmnews

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

fun Project.configureCompose(
    commonExtension: CommonExtension<*, *, *, *>
) {
    pluginManager.apply {
        apply("org.jetbrains.compose")
    }
    val libs = extensions.getByType(VersionCatalogsExtension::class).named("libs")
    with(commonExtension) {
        buildFeatures {
            compose = true
        }
        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("androidxComposeCompiler").get().toString()
        }
    }

    dependencies{
        "implementation"(libs.findLibrary("androidx.activity.compose").get())
    }
}