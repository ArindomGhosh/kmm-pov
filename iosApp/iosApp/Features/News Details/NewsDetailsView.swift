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
        ScrollView {
            VStack(alignment: .leading) {
                imageView
                VStack(alignment: .leading, spacing: 8.0) {
                    titleText
                    publishedByText
                    publishedAtText
                    descriptionText
                    contentText
                }
                .padding()
            }
        }
        .navigationTitle(news.source)
        .navigationBarTitleDisplayMode(.inline)
    }
    
    private var imageView: some View {
        AsyncImage(url: news.imageUrl) { image in
            image
                .resizable()
                .aspectRatio(contentMode: .fill)
        } placeholder: {
            Color(.gray)
                .opacity(0.3)
        }
        .aspectRatio(2.0, contentMode: .fill)
    }
    
    private var titleText: some View {
        Text(news.title)
            .font(.headline)
    }
    
    private var publishedByText: some View {
        Text("Published by \(news.source)")
            .foregroundColor(Color.gray)
            .font(.caption)
    }
    
    private var publishedAtText: some View {
        Text(news.publishedAt)
            .foregroundColor(Color.gray)
            .font(.caption)
    }
    
    private var descriptionText: some View {
        Text(news.description)
            .font(.subheadline)
    }
    
    private var contentText: some View {
        Text(news.content)
            .font(.subheadline)
            .padding(.top, 8.0)
    }
}
