//
//  NewsCellView.swift
//  iosApp
//
//  Created by Gajarlawar, Akshay Narendra on 18/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct NewsCellView: View {
    
    let news: NewsArticleWrapper
    let onReadMore: () -> Void
    
    var body: some View {
        ContentCardView {
            VStack(alignment: .leading) {
                Text(news.title)
                    .font(.headline)
                    .padding(.bottom, 4.0)
                
                Text(news.description)
                    .lineLimit(4)
                    .font(.subheadline)
                    .padding(.bottom, 4.0)
                
                Button {
                    onReadMore()
                } label: {
                    Text("Read More")
                        .font(.footnote)
                        .foregroundColor(.white)
                        .padding(8.0)
                        .background(Color.blue)
                        .cornerRadius(4.0)
                }

            }
            .frame(maxWidth: .infinity, alignment: .leading)
        }
    }
}
