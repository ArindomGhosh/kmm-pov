import SwiftUI
import shared

struct NewsListViewController: UIViewControllerRepresentable {

    // MARK: - Variables
    let newsLisViewModel: NewsScreenViewModel

    // MRAK: Protocol Methods -
    func makeUIViewController(context: Context) -> UIViewController {
//        Newslistsceen_iosKt.NewsListScreeController(newsScreenViewModel: newsLisViewModel)
        
            Newsdetailscreen_iosKt.NewDetailScreenController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct NewsListView: View {

    let newsLisViewModel: NewsScreenViewModel

	var body: some View {
        NewsListViewController(newsLisViewModel: newsLisViewModel)
            .ignoresSafeArea(.keyboard)
            .onDisappear {
                newsLisViewModel.clear()
            }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        NewsListView(newsLisViewModel: KoinApplication.inject())
	}
}
