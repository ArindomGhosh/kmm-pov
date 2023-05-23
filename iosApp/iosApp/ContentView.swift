import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {
    var newsLisViewModel:NewsScreenViewModel
    
    
    func makeUIViewController(context: Context) -> UIViewController {
        Newslistsceen_iosKt.NewListScreeController(newsScreenViewModel:newsLisViewModel)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}


struct ContentView: View {
    
    @ObservedObject private(set) var contentViewModel:ContenViewModel

    
	var body: some View {
        ComposeView(newsLisViewModel: contentViewModel.newsScreenViewModel)
            .ignoresSafeArea(.keyboard)
            .onDisappear {
                contentViewModel.destroy()
            }
        
	}
}

@MainActor
extension ContentView{
    class ContenViewModel:ObservableObject{
        @LazyKoin
        var newsScreenViewModel:NewsScreenViewModel

        func destroy(){
            newsScreenViewModel.clear()
        }
    }
}


struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView(contentViewModel: ContentView.ContenViewModel())
	}
}
