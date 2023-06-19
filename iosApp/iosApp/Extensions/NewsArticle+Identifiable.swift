//
//  NewsArticle+Identifiable.swift
//  iosApp
//
//  Created by Gajarlawar, Akshay Narendra on 18/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

extension Article: Identifiable {
    /// Conforming to `Identifiable` protocol not required here i.e.
    /// May be because `NewsArticle`  have the `hash()` function that might be fullfilling the requirement of the `id` property.
    /*
    public var id: UInt {
        self.hash()
    }
    */
}

