import SwiftUI

/// View to display the News list fetched from KMM
struct NewsListView: View {

    /// Instance of `NewsListViewModel` as ViewModel for this View
    @ObservedObject var viewModel: NewsListViewModel
    
    /// News thats has selected to read more about
    @State var selectedNews: NewsArticleWrapper? = nil
    
    /// Flag to activate navigation when selectedNew updated
    var isNewsSelected: Binding<Bool> {
        Binding<Bool>(
            get: {
                selectedNews != nil
            },
            set: { isActive in
                if !isActive {
                    selectedNews = nil
                }
            }
        )
    }
    
    // MARK: - Initializer
    /// Parameter
    /// - viewModel: ViewModel to handle business logic for the view
    init(viewModel: NewsListViewModel) {
        self.viewModel = viewModel
        viewModel.observeNewsFeed()
        
        /// Hide the List row separator, works for all iOS version.
        /// Remove this when minimum deployment target is set to iOS 15, instead use the modifier `.listRowSeparator(.hidden)` on each row of the List.
        // UITableView.appearance().separatorStyle = .none
    }
    
    // MARK: - View body

	var body: some View {
        NavigationView {
            AsyncContentView(state: $viewModel.viewState) {
                newsListView
            } loadingView: {
                loadingView
            } emptyView: {
                emptyStateView
            } errorView: {
                errorStateView
            }
            .navigationTitle("Top News")
            .ignoresSafeArea(.keyboard)
        }
	}
    
    /// View to be be displayed while fetching the news
    private var loadingView: some View {
        VStack {
            ProgressView()
            Spacer()
                .frame(height: 8.0)
            Text("Loading...")
        }
    }
    
    /// View to be displayed after loading the news and at least 1 news article is available
    private var newsListView: some View {
        VStack {
            List(viewModel.newsList) { article in
                let wrapper = NewsArticleWrapper(article: article)
                NewsCellView(news: wrapper) {
                    selectedNews = wrapper
                }
                .listRowSeparator(.hidden)
            }
            .listStyle(.plain)
            
            NavigationLink(isActive: isNewsSelected) {
                newsDetailsView
            } label: {
                EmptyView()
            }
        }
    }
    
    /// View to be displayed when there is no error and no news
    private var emptyStateView: some View {
        Text("News unavailable at the moment.\nPlease try again after some time")
    }
    
    /// View to be display when API returns error
    @ViewBuilder
    var errorStateView: some View {
        if let errorMessage = viewModel.errorMessage {
            VStack {
                Text(errorMessage)
                Button("Try Again") {
                    viewModel.refetchNews()
                }
            }
        }
    }
     
    /// View for news details, to be navigate to when a news is selected from the list
    @ViewBuilder
    var newsDetailsView: some View {
        if let news = selectedNews  {
            NewsDetailsView(news: news)
        }
    }
}

// MARK: - Preview

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        NewsListView(viewModel: NewsListViewModel(newsScreenViewModel: KoinApplication.inject()))
	}
}
