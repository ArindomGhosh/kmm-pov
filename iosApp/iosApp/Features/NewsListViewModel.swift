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
    
    let newsLisViewModel: NewsScreenViewModel
    
    @Published var newsList: [NewsArticle] = []
    
    init(newsLisViewModel: NewsScreenViewModel) {
        self.newsLisViewModel = newsLisViewModel
    }
    
    func subscribeToNewsFeed() {
        newsLisViewModel.uiState.collect(collector: FlowCollector<NewsUiState> { [weak self] state in
            guard let self else {
                return
            }
            
            if let _ = state as? NewsUiStateLoading {
                print("Loading News...")
            }
            else if let loaded = state as? NewsUiStateLoaded {
                print("Loaded \(loaded.newsList.count) News")
                newsList = loaded.newsList
            }
            else if let error = state as? NewsUiStateError {
                print("Error: \(error.errorEntity.message)")
            }
        }) { error in
            if let err = error {
                print("Error subscribing to news feed")
                print(err.localizedDescription)
            }
        }
    }
}
