//
//  NewsDetailsView.swift
//  iosApp
//
//  Created by Gajarlawar, Akshay Narendra on 18/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct NewsDetailsView: View {
    
    // MARK: - Properties
    
    /// ViewModel for the View
    @ObservedObject var viewModel: NewsDetailsViewModel
    
    // MARK: - Initializer
    /// Parameters
    /// - viewModel: Handles business logic of the View
    init(viewModel: NewsDetailsViewModel) {
        self.viewModel = viewModel
        viewModel.loadNewsDetails()
    }
    
    // MARK: - View Body
    
    var body: some View {
        AsyncContentView(state: $viewModel.viewState) {
            newsDetailsView
        } loadingView: {
            loadingView
        } emptyView: {
            EmptyView()
        } errorView: {
            EmptyView()
        }
        .navigationTitle(viewModel.source)
        .navigationBarTitleDisplayMode(.inline)
    }
    
    /// View to be be displayed while fetching the news details
    private var loadingView: some View {
        SimpleLoader(message: "Loading News Details")
    }
    
    /// View to be displayed after loading the news details
    private var newsDetailsView: some View {
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
    }
    
    private var imageView: some View {
        AsyncImage(url: viewModel.imageUrl) { image in
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
        Text(viewModel.title)
            .font(.headline)
    }
    
    private var publishedByText: some View {
        Text("Published by \(viewModel.source)")
            .foregroundColor(Color.gray)
            .font(.caption)
    }
    
    private var publishedAtText: some View {
        Text(viewModel.publishedAt)
            .foregroundColor(Color.gray)
            .font(.caption)
    }
    
    private var descriptionText: some View {
        Text(viewModel.description)
            .font(.subheadline)
    }
    
    private var contentText: some View {
        Text(viewModel.content)
            .font(.subheadline)
            .padding(.top, 8.0)
    }
}
