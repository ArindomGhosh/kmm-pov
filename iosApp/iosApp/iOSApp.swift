import SwiftUI
import shared

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
            NewsListView(viewModel: NewsListViewModel(newsScreenViewModel: KoinApplication.inject()))
		}
	}
}
