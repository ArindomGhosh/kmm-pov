# :construction: kmm-news
## What is KMM? :confused:
:point_right: **[KMM](https://kotlinlang.org/docs/multiplatform.html)** is a framework developed and maintained by [jetbrains](https://www.jetbrains.com/) designed to share code across platforms primarily targeting: Android, iOS, Desktop, Web. So that the developers can share their modules developed in [Kotlin](https://kotlinlang.org/) across different platform :heart_eyes:.

## How does it work and how its different from other Cross-Platform application? :monocle_face:
:point_right: First of all **KMM** is not a *Cross Platform* in a conventional sense :astonished:. KMM relies on [Kotlin](https://kotlinlang.org/) compiler to generate binaries for native platfoms using **Kotlin compiler backend** which could be called from **Native Platforms** :smirk:.\
In short don't re-invent the :wheel_of_dharma:, shareing as much as you can while developing your application using your native framework('s).\
:book: To read more about kotlin compiler please check the [blogpost](https://blog.jetbrains.com/kotlin/2021/10/the-road-to-the-k2-compiler/).

## Introduction to the project: :technologist: :woman_technologist:
**kmm-news** is a simple news reading application built using KMM framework. 
The goal of the project is to explore [KMM](https://kotlinlang.org/docs/multiplatform.html) based on [Jetnews](https://github.com/android/compose-samples/tree/master/JetNews) to :microscope: on following topics: 

### :scroll: Topics to be covered:
- :office: Architecture
  - [Layered Architecture](https://developer.android.com/topic/architecture)
  - [Modularization](https://developer.android.com/topic/modularization)
  - [nia-modularization](https://github.com/android/nowinandroid/blob/main/docs/ModularizationLearningJourney.md)
  - [nia-architecture](https://github.com/android/nowinandroid/blob/main/docs/ArchitectureLearningJourney.md)
- :star_struck: UI: The UI is build using [compose-multiplatform](https://github.com/JetBrains/compose-multiplatform):
  - [Android](https://developer.android.com/jetpack/compose)
  - [iOS](https://github.com/JetBrains/compose-multiplatform-ios-android-template/#readme) 
  - [Desktop](https://github.com/JetBrains/compose-multiplatform-desktop-template/#readme)*
  - [Web](https://kotl.in/wasm-compose-example)*
- :signal_strength: Network Layer: The api calls would be made using [ktor](https://ktor.io/docs/getting-started-ktor-client.html#new-project).
- :floppy_disk: Offline Support: The news articles would be saved offline as bookmarked using [sqldelight](https://cashapp.github.io/sqldelight/2.0.0-alpha05/)
- :syringe: DI: Dependency Injection is implemented using [koin](https://insert-koin.io/)
- :hammer: built-tool: build using gradle with [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
  - [build-logic](https://developer.squareup.com/blog/herding-elephants/): Creating gradle plugins to better manage dependencies across modules, more details in te link attached.
  - [versionCatalogs](https://docs.gradle.org/current/userguide/platforms.html#sub:version-catalog-declaration): Share dependency versions between projects.
- :card_index_dividers: Impact on .apk and .ipa sizes wile sharing logic across platforms.

***Note: This is a work in progress project would keep adding contents as we build.***
  
