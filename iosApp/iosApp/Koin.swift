//
//  Koin.swift
//  iosApp
//
//  Created by Ghosh, Arindom on 22/05/23.
//  Copyright © 2023 orgName. All rights reserved.
//
import shared

typealias KoinApplication = Koin_coreKoinApplication

typealias Koin = Koin_coreKoin

extension KoinApplication {
    static let shared = companion.start()

    @discardableResult
    static func start() -> KoinApplication {
        shared
    }
}

extension KoinApplication {
    private static let keyPaths: [PartialKeyPath<Koin>] = [\.getNewsScreenViewModel]

    static func inject<T>() -> T {
        shared.inject()
    }

    func inject<T>() -> T {
        for partialPathKey in Self.keyPaths {
            guard let keyPath = partialPathKey as? KeyPath<Koin, T> else {continue}
            return koin[keyPath: keyPath]
        }
        fatalError("\(T.self) not registered with KoinApplication")
    }
}

@propertyWrapper
struct LazyKoin<T> {
    lazy var wrappedValue: T = {KoinApplication.shared.inject()}()

    init() { }
}
