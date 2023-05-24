import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {
    let newsLisViewModel:NewsScreenViewModel
    
    func makeUIViewController(context: Context) -> UIViewController {
        Newslistsceen_iosKt.NewListScreeController(newsScreenViewModel:newsLisViewModel)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}


struct ContentView: View {

    let newsLisViewModel:NewsScreenViewModel
    
	var body: some View {
        ComposeView(newsLisViewModel: newsLisViewModel)
            .ignoresSafeArea(.keyboard)
            .onDisappear {
                newsLisViewModel.clear()
            }
        
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView(newsLisViewModel: KoinApplication.inject())
	}
}
