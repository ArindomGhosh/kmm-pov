//
//  SimpleLoader.swift
//  iosApp
//
//  Created by Gajarlawar, Akshay Narendra on 19/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct SimpleLoader: View {
    
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

struct SimpleLoader_Previews: PreviewProvider {
    static var previews: some View {
        SimpleLoader()
    }
}
