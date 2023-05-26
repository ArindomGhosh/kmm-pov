pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenCentral()
    }
    includeBuild("build-logic")
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "kmm-news"
include(":androidApp")
include(":kmm:shared")
include(":kmm:core:network")
include(":kmm:feature:news")
include(":kmm:core:ui")
include(":kmm:domain:news")
include(":kmm:core:data")
include(":kmm:core:common")
include(":kmm:domain:common")
