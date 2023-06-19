//
//  NewsDetailsViewModel.swift
//  iosApp
//
//  Created by Gajarlawar, Akshay Narendra on 19/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

final class NewsDetailsViewModel: ObservableObject {
    
    // MARK: - Properties
    
    /// Unique identifier of the news article
    let articleId: Int64
    
    /// Instance of `NewsScreenViewModel` from KMM
    let newsDetailsScreenViewModel: NewsDetailsScreenViewModel
    
    /// Loaded news article
    private var news: NewsArticleWrapper?
    
    /// UI state of the View - loading, content, empty or error
    @Published var viewState: ViewState = .empty
    
    // MARK: - Initializer
    /// Parameters
    /// - articleId: to fetch news article from
    /// - newsDetailsScreenViewModel: 
    init(articleId: Int64,
         newsDetailsScreenViewModel: NewsDetailsScreenViewModel = KoinApplication.inject()) {
        self.articleId = articleId
        self.newsDetailsScreenViewModel = newsDetailsScreenViewModel
    }
    
    deinit {
        newsDetailsScreenViewModel.clear()
    }
    
    // MARK: - Functions
    
    func loadNewsDetails() {
        observeNewsDetailsUIState()
        newsDetailsScreenViewModel.getArticleFromId(articleId: self.articleId)
    }
    
    /// Observe stream of news using `FlowCollector`
    private func observeNewsDetailsUIState() {
        newsDetailsScreenViewModel.uiState.collect(collector: FlowCollector<NewsDetailsUiState> { [weak self] state in
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
    
    private func handleUIState(_ state: NewsDetailsUiState) {
        if let _ = state as? NewsDetailsUiStateLoading {
            viewState = .loading
        }
        else if let loaded = state as? NewsDetailsUiStateLoaded {
            news = NewsArticleWrapper(article: loaded.article)
            viewState = .content
        }
    }
    
    // MARK: - News details
    
    var title: String {
        news?.title ?? ""
    }
    
    var description: String {
        news?.description ?? ""
    }
    
    var content: String {
        news?.content ?? ""
    }
    
    var source: String {
        news?.source ?? ""
    }
    
    var publishedAt: String {
       news?.publishedAt ?? ""
    }
    
    var imageUrl: URL? {
        news?.imageUrl
    }
}
