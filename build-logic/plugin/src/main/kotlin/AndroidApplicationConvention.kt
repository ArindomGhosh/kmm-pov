import com.android.build.api.dsl.ApplicationExtension
import com.example.kmmnews.configureKotlinAndroid
import com.example.kmmnews.kotlinOptions
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            val libs=extensions.getByType(VersionCatalogsExtension::class).named("libs")
            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig {
                    versionCode = libs.findVersion("applicationVersionCode").get().toString().toInt()
                    versionName = libs.findVersion("applicationVersionName").get().toString()
                }
                kotlinOptions {
                    jvmTarget = JavaVersion.VERSION_17.toString()
                }
            }

            dependencies {
                "implementation"(project(":kmm:shared"))
            }
        }
    }
}