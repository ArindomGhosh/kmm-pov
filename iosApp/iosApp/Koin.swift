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
