//
//  AsyncContentView.swift
//  iosApp
//
//  Created by Gajarlawar, Akshay Narendra on 18/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

enum ViewState {
    case content
    case loading
    case empty
    case error
}

// The View will dynamically change its child view based on `state` value
struct AsyncContentView<Content, Loading, Empty, Error>: View where Content: View, Loading: View, Empty: View, Error: View {
    typealias ContentBuilder = () -> Content
    typealias LoadingBuilder = () -> Loading
    typealias EmptyBuilder = () -> Empty
    typealias ErrorBuilder = () -> Error
    
    @Binding var state: ViewState
    
    let contentView: ContentBuilder
    let loadingView: LoadingBuilder
    let emptyView: EmptyBuilder
    let errorView: ErrorBuilder
    
    var body: some View {
        switch state {
        case .content:
            contentView()
        case .loading:
            loadingView()
        case .empty:
            emptyView()
        case .error:
            errorView()
        }
    }
}

