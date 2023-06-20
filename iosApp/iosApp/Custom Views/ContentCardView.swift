//
//  ContentCardView.swift
//  iosApp
//
//  Created by Gajarlawar, Akshay Narendra on 18/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

// The container view to have corner radius and shadow
struct ContentCardView<Content: View>: View {
    let contentView: () -> Content
    
    var body: some View {
        contentView()
            .padding()
            .background(Color.white)
            .cornerRadius(8.0)
            .shadow(color: Color.gray.opacity(0.2), radius: 4.0, x: 0, y: 2.0)
    }
}

