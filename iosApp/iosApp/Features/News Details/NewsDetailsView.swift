//
//  NewsDetailsView.swift
//  iosApp
//
//  Created by Gajarlawar, Akshay Narendra on 18/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct NewsDetailsView: View {
    
    let news: NewsArticleWrapper
    
    var body: some View {
        Text(news.title)
            .navigationTitle("Published by \(news.source)")
            .navigationBarTitleDisplayMode(.inline)
    }
}
