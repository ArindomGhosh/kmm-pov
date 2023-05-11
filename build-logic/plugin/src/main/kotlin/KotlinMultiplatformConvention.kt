import com.android.build.gradle.LibraryExtension
import com.example.kmmnews.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getting
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class KotlinMultiplatformConvention: Plugin<Project> {
    override fun apply(target: Project) {
        with(target){
            pluginManager.apply{
                apply("org.jetbrains.kotlin.multiplatform")
                apply("com.android.library")
            }
            extensions.configure<LibraryExtension>{
                sourceSets {
                    getByName("main"){
                        manifest.srcFile("./src/androidMain/AndroidManifest.xml")
                    }
                }
                configureKotlinAndroid(this)
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