//
//  SimpleLoader.swift
//  iosApp
//
//  Created by Gajarlawar, Akshay Narendra on 19/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

// The view to show ProgressView along with some message.
struct SimpleLoader: View {
    
    /// Message to display below `ProgressView`
    let message: String
    
    init(message: String = "Loading...") {
        self.message = message
    }
    
    var body: some View {
        VStack {
            ProgressView()
            Spacer()
                .frame(height: 8.0)
            Text(message)
        }
    }
}
