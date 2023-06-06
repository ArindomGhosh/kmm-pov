import com.android.build.gradle.LibraryExtension
import com.example.kmmnews.configureKotlinAndroid
import org.gradle.api.Action
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.getting
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

class KotlinMultiplatformConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("org.jetbrains.kotlin.multiplatform")
                apply("com.android.library")
            }
            extensions.configure<LibraryExtension> {
                sourceSets {
                    getByName("main") {
                        manifest.srcFile("./src/androidMain/AndroidManifest.xml")
                    }
                }
                configureKotlinAndroid(this)
            }
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            extensions.configure<KotlinMultiplatformExtension> {
                android()
                iosX64()
                iosArm64()
                iosSimulatorArm64()

                sourceSets {
                    named("commonMain") {
                        dependencies {
                            implementation(libs.findLibrary("napier").get())
                        }
                    }
                }
            }

        }
    }
}

internal fun KotlinMultiplatformExtension.`sourceSets`(configure: Action<NamedDomainObjectContainer<KotlinSourceSet>>): Unit =
    (this as org.gradle.api.plugins.ExtensionAware).extensions.configure("sourceSets", configure)



