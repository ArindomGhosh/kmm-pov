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

### KMM News architecture 👇

<img width="1383" alt="Screenshot 2023-05-24 at 5 00 47 PM" src="https://github.com/Deloitte/dd-poc-kmm/assets/70739057/30bd47a4-3082-4f73-8870-ecdac1c589d3">

## 🎯 When to choose KMM ?

KMM is a new approach towards cross platform application development where it brings best of hybrid application's one code base, write once run anywhere principle
and also native application performance. As already mentioned above, most prominent usp of KMM is sharing common code across various platforms, which reduces duplicity and promotes building reusable components.
KMM (Kotlin Multiplatform Mobile) is a technology that allows you to share code between different platforms, such as Android and iOS, in mobile app development. Here are some situations where choosing KMM for mobile app development might be beneficial:

👉 Multi-target Apps: If you need to develop an app for both Android and iOS platforms, KMM can be a good choice. It allows you to write shared business logic and data access code in Kotlin, which can be used by both platforms, reducing code duplication and development efforts.

👉 Code resusability/sharing: If you have complex business logic or data manipulation requirements that need to be consistent across platforms, KMM can help you share the codebase. By writing the code once in Kotlin and sharing it between platforms, you can ensure consistency and reduce the chances of bugs introduced due to platform-specific implementation differences.

👉 Faster dev cycles: KMM can speed up the development process by enabling code reuse. Instead of building separate codebases for Android and iOS, you can write common code in Kotlin, reducing the time and effort required for development, testing, and maintenance.

👉 Team efficiency: If you have a team of developers with expertise in <ins>Kotlin</ins>, adopting KMM can be advantageous. The team can leverage their existing Kotlin knowledge and skills to build mobile apps for both platforms, rather than learning and working with different programming languages.

👉 Performance optimization: KMM allows you to optimize performance-critical parts of your app by writing platform-specific code in Swift for iOS and Kotlin for Android. This way, you can achieve platform-specific optimizations while still sharing the majority of the code.

👉 Maintainability: With KMM, code maintenance becomes easier as you have a single codebase to manage. Bug fixes, feature additions, and updates can be applied once, reducing the risk of inconsistencies between platforms and improving the overall maintainability of the codebase.

💡 <i>However, it's important to note that KMM might not be suitable for every app project. Consider the complexity of your app, platform-specific requirements, and the availability of third-party libraries and frameworks when deciding whether to choose KMM for mobile app development. Additionally, keep in mind that KMM is a relatively new technology, so it's essential to consider the maturity of the ecosystem and community support for your specific use case.</i>


## ✅ Comparison and trade-offs with other prominent cross platform solutions

When comparing KMM (Kotlin Multiplatform Mobile), React Native, Flutter, and Ionic, here's an overview of their key characteristics in the below table :


| Characteristics                           | KMM                                                                                                                                               | React Native                                                                                                                                                             | Flutter                                                                                                                           | ionic                                                                                                                         |
|-------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------|
| Language and Development Experience | Uses Kotlin as the primary language, providing a modern and expressive  development experience for Android developers.                            | Uses JavaScript and the React framework, which has a  large community and extensive resources.                                                                           | Uses Dart and offers a reactive framework with a rich set of  pre-built UI components.                                            | Uses web technologies such as HTML, CSS, and JavaScript/TypeScript,  making it familiar for web developers.                   |
| Performance                         | By sharing code between platforms, KMM can improve performance and reduce code duplication.  Platform-specific optimizations can also be applied. | The bridge between JavaScript and native components can introduce some performance overhead,  and platform-specific code might be required for performance optimization. | Compiles to native code and offers a high-performance rendering engine,  resulting in fast and native-like performance.           | Renders using web views, which might not match the performance of fully native solutions.                                     |
| Code Sharing                        | Allows sharing non-UI code, such as business logic and data access, between platforms.  UI components need to be implemented separately.          | Enables sharing code for UI components, business logic, and data access,  providing a wide range of pre-built UI components.                                             | Enables code sharing for UI components, business logic, and data access,  with a comprehensive set of customizable UI components. | Shares UI code across platforms using web technologies, offering a single codebase for multiple platforms.                    |
| Ecosystem and Community Support     | Kotlin has a growing ecosystem and community support, but it is relatively newer  compared to other frameworks.                                   | Benefits from a mature ecosystem with extensive community support and a wide range  of third-party libraries and packages.                                               | Has a growing ecosystem and community support, providing pre-built packages and libraries for various functionalities.            | Relies on web technologies, benefitting from a vast web ecosystem, community support, and extensive libraries and frameworks. |
| Platform support                    | Currently supports Android,iOS,Desktop and Web(beta), integrating well with Android Studio for Android development.                               | Supports Android, iOS, web, and desktop platforms through community-driven efforts                                                                                       | Supports Android, iOS, web, desktop (Windows, macOS, Linux), and embedded systems.                                                | Supports Android, iOS, web, and desktop platforms, utilizing web views for rendering.                                         |

## 📌 Guidance 
Choosing the right framework depends on specific project requirements, team expertise, performance needs, and ecosystem support. KMM is a good fit for Kotlin developers focusing on Android and iOS. React Native is ideal for JavaScript developers seeking extensive community support and code sharing for UI components. Flutter offers native-like performance and is suitable for multi-platform development. Ionic targets web and mobile platforms, 
providing a single codebase with web technology expertise. Consider these factors when making a decision.




***Note: This is a work in progress project would keep adding contents as we build.***
  

