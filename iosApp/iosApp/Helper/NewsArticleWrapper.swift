//
//  NewsArticleWrapper.swift
//  iosApp
//
//  Created by Gajarlawar, Akshay Narendra on 18/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

class NewsArticleWrapper {
    
    private let article: NewsArticle
    
    init(article: NewsArticle) {
        self.article = article
    }
    
    var title: String {
        article.title
    }
    
    var description: String {
        article.description_
    }
    
    var content: String {
        article.content
    }
    
    var source: String {
        article.source
    }
    
    var imageUrl: URL? {
        URL(string: article.imageUrl)
    }
}

