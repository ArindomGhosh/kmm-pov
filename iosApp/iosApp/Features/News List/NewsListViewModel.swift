//
//  NewsListViewModel.swift
//  iosApp
//
//  Created by Gajarlawar, Akshay Narendra on 18/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

class NewsListViewModel: ObservableObject {
    
    /// Instance of `NewsScreenViewModel` from KMM
    let newsScreenViewModel: NewsScreenViewModel
    
    // MARK: - Published properties
    @Published var viewState: ViewState = .empty
    @Published var newsList: [Article] = []
    @Published var errorMessage: String?
    
    
    // MARK: - Initializer
    /// Parameters
    /// - newsScreenViewModel: ViewModel from KMM to fetch news
    init(newsScreenViewModel: NewsScreenViewModel) {
        self.newsScreenViewModel = newsScreenViewModel
        viewState = .loading
    }
    
    deinit {
        newsScreenViewModel.clear()
    }
    
    // MARK: - Functions
    
    /// Observe stream of news using `FlowCollector`
    func observeNewsFeed() {
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
