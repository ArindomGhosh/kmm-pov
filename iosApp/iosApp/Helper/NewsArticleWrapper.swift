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
    
    private let article: Article
    
    init(article: Article) {
        self.article = article
    }
    
    var articleId : Int64 {
        article.articleId
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
    
    var publishedAt: String {
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "yyyy-MM-dd'T'HH:mm:ssZ"
        if let date = dateFormatter.date(from: article.publishedAt) {
            dateFormatter.dateFormat = "dd.MM.yyyy, hh:mm a"
            return dateFormatter.string(from: date)
        }
        return article.publishedAt
    }
    
    var imageUrl: URL? {
        URL(string: article.imageUrl)
    }
}

