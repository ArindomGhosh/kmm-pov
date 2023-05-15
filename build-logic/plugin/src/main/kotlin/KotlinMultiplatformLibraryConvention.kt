import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotlinMultiplatformLibraryConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.kmmnews.kotlin.multiplatform")
            }
            extensions.configure<KotlinMultiplatformExtension> {
                android()

                iosX64()
                iosArm64()
                iosSimulatorArm64()
            }
        }
    }
}