# :construction: kmm-news
## What is KMM? :confused:
:point_right: **[KMM](https://kotlinlang.org/docs/multiplatform.html)** is a framework developed and maintained by [jetbrains](https://www.jetbrains.com/) designed to share code across platforms primarily targeting: Android, iOS, Desktop, Web. So that the developers can share their modules developed in [Kotlin](https://kotlinlang.org/) across different platform :heart_eyes:.

## KMM Layers
<img width="806" alt="Screenshot 2023-05-22 at 11 52 49 AM" src="https://github.com/Deloitte/dd-poc-kmm/assets/70739057/e69e0ea4-ad7b-47ea-9add-665d00ef194b">


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
- :card_index_dividers: Impact on .apk and .ipa sizes while sharing logic across platforms.

### KMM News architecture

<img width="1383" alt="Screenshot 2023-05-24 at 5 00 47 PM" src="https://github.com/Deloitte/dd-poc-kmm/assets/70739057/30bd47a4-3082-4f73-8870-ecdac1c589d3">

### When to choose KMM ?

KMM is a new approach towards cross platform application development where it brings best of hybrid application's one code base, write once run anywhere principle
and also native application performance. As already mentioned above Most prominent usp of KMM is sharing common code across various platforms, which reduces duplicity and promotes building reusable components.

KMM (Kotlin Multiplatform Mobile) is a technology that allows you to share code between different platforms, such as Android and iOS, in mobile app development. Here are some situations where choosing KMM for mobile app development might be beneficial:

Cross-platform app development: If you need to develop an app for both Android and iOS platforms, KMM can be a good choice. It allows you to write shared business logic and data access code in Kotlin, which can be used by both platforms, reducing code duplication and development efforts.

Code sharing: If you have complex business logic or data manipulation requirements that need to be consistent across platforms, KMM can help you share the codebase. By writing the code once in Kotlin and sharing it between platforms, you can ensure consistency and reduce the chances of bugs introduced due to platform-specific implementation differences.

Rapid development: KMM can speed up the development process by enabling code reuse. Instead of building separate codebases for Android and iOS, you can write common code in Kotlin, reducing the time and effort required for development, testing, and maintenance.

Team efficiency: If you have a team of developers with expertise in Kotlin, adopting KMM can be advantageous. The team can leverage their existing Kotlin knowledge and skills to build mobile apps for both platforms, rather than learning and working with different programming languages.

Performance optimization: KMM allows you to optimize performance-critical parts of your app by writing platform-specific code in Swift/Objective-C for iOS and Java/Kotlin for Android. This way, you can achieve platform-specific optimizations while still sharing the majority of the code.

Code maintenance: With KMM, code maintenance becomes easier as you have a single codebase to manage. Bug fixes, feature additions, and updates can be applied once, reducing the risk of inconsistencies between platforms and improving the overall maintainability of the codebase.

However, it's important to note that KMM might not be suitable for every app project. Consider the complexity of your app, platform-specific requirements, and the availability of third-party libraries and frameworks when deciding whether to choose KMM for mobile app development. Additionally, keep in mind that KMM is a relatively new technology, so it's essential to consider the maturity of the ecosystem and community support for your specific use case.


### Comparison with other prominent cross platform solutions

KMM (Kotlin Multiplatform Mobile), React Native, and Flutter are three popular cross-platform frameworks used for mobile app development. Here's a comparison of these frameworks:

Language and Development Experience:
KMM: Uses Kotlin as the primary language, which is a modern, expressive, and statically typed language. It provides a seamless integration with Android Studio and offers a familiar development experience for Android developers.
React Native: Uses JavaScript and React framework for development. It has a large community and a wide range of libraries and packages available, making it easier to find solutions and resources.
Flutter: Uses Dart as the programming language. It offers a modern and reactive framework with a rich set of pre-built UI components. It has a fast development cycle and a hot-reload feature, allowing developers to see changes instantly.
Performance:
KMM: Provides the advantage of sharing business logic and data access code between platforms, resulting in improved performance and reduced code duplication. Platform-specific optimizations can be implemented for performance-critical parts.
React Native: Uses a bridge to communicate between JavaScript and native components, which can introduce some performance overhead. It might require writing platform-specific code for performance optimization.
Flutter: Offers a high-performance rendering engine and native-like performance since it compiles to native code. The UI is rendered directly without the need for a bridge, resulting in faster performance.
Code Sharing:
KMM: Allows sharing code for business logic, data access, and other non-UI related functionalities. UI components need to be implemented separately for each platform.
React Native: Allows sharing code for UI components, business logic, and data access. It provides a wide range of pre-built UI components that can be used across platforms.
Flutter: Enables code sharing for UI components, business logic, and data access. It offers a comprehensive set of customizable UI components and widgets that work consistently across platforms.
Ecosystem and Community Support:
KMM: Kotlin has a growing ecosystem and community support, but it is relatively newer compared to React Native and Flutter. It provides good integration with Android tools and libraries.
React Native: Has a large and mature ecosystem with extensive community support. It offers a wide range of third-party libraries and packages, making it easier to find solutions and resources.
Flutter: Has a growing ecosystem and community support. It provides a rich set of pre-built packages and libraries for various functionalities.
Platform Support:
KMM: Currently supports Android and iOS platforms. It integrates well with Android Studio for Android development.
React Native: Supports both Android and iOS platforms, as well as other platforms like web and desktop through community-driven efforts.
Flutter: Supports multiple platforms including Android, iOS, web, desktop (Windows, macOS, Linux), and embedded systems (Raspberry Pi, etc.).
Choosing the right framework depends on various factors such as project requirements, team expertise, performance needs, and ecosystem support. If you have a Kotlin background, need to share non-UI code, and focus on Android and iOS, KMM might be a suitable choice. If you prefer JavaScript and want a large community and extensive library support, React Native could be a good option. Flutter, on the other hand, is ideal if you prioritize native-like performance and want to target multiple platforms with a single codebase.

|   | KMM      | React Native  | Flutter  |  ionic  |
|----------|:-------------:|---------:|:----------|
| Language and Development Experience |
| Performance | 
| Code Sharing |
| Ecosystem and Community Support |
| Platform |

## Conclusion 
Choosing the right framework depends on specific project requirements, team expertise, performance needs, and ecosystem support. KMM is a good fit for Kotlin developers focusing on Android and iOS. React Native is ideal for JavaScript developers seeking extensive community support and code sharing for UI components. Flutter offers native-like performance and is suitable for multi-platform development. Ionic targets web and mobile platforms, 
providing a single codebase with web technology expertise. Consider these factors when making a decision.




***Note: This is a work in progress project would keep adding contents as we build.***
  

