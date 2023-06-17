import SwiftUI

struct NewsListView: View {

    @ObservedObject var viewModel: NewsListViewModel
    
    init(viewModel: NewsListViewModel) {
        self.viewModel = viewModel
        viewModel.subscribeToNewsFeed()
    }

	var body: some View {
        Text("News Count: \(viewModel.newsList.count)")
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        NewsListView(viewModel: NewsListViewModel(newsLisViewModel: KoinApplication.inject()))
	}
}
