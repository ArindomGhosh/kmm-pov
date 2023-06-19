//
//  NewsListViewModel.swift
//  iosApp
//
//  Created by Gajarlawar, Akshay Narendra on 18/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

final class NewsListViewModel: ObservableObject {
    
    // MARK: - Properties
    
    /// Instance of `NewsScreenViewModel` from KMM
    let newsScreenViewModel: NewsScreenViewModel
    
    /// UI state of the View - loading, content, empty or error
    @Published var viewState: ViewState = .empty
    
    /// List of the news fetched from API
    @Published var newsList: [Article] = []
    
    /// API error message if any
    @Published var errorMessage: String?
    
    
    // MARK: - Initializer
    /// Parameters
    /// - newsScreenViewModel: ViewModel from KMM to fetch news
    init(newsScreenViewModel: NewsScreenViewModel = KoinApplication.inject()) {
        self.newsScreenViewModel = newsScreenViewModel
        viewState = .loading
    }
    
    deinit {
        newsScreenViewModel.clear()
    }
    
    // MARK: - Functions
    
    /// Observe stream of news using `FlowCollector`
    func observeNewsListUIState() {
        newsScreenViewModel.uiState.collect(collector: FlowCollector<NewsUiState> { [weak self] state in
            guard let self else {
                return
            }
            self.handleUIState(state)
        }) { error in
            if let err = error {
                print(err.localizedDescription)
            }
        }
    }
    
    /// Reload news using `getNewsForCountry()` available from KMM
    func refetchNews() {
        newsScreenViewModel.getNewsForCountry(countryName: "us")
    }
    
    // MARK: - Private functions
    
    private func handleUIState(_ state: NewsUiState) {
        if let _ = state as? NewsUiStateLoading {
            print("Loading News...")
            viewState = .loading
        }
        else if let loaded = state as? NewsUiStateLoaded {
            newsList = loaded.newsList
            print("Loaded \(newsList.count) News")
            viewState = .content
        }
        else if let error = state as? NewsUiStateError {
            print(error.errorEntity.message)
            viewState = .error
        }
    }
    
    
}
