package main;

import views.MainWindow;
import views.chat.ChatView;
import views.login.LoginView;

public class Main {
	
	private MainWindow ventanaPrincipal;
	private LoginView loginview;
	private ChatView chatview;

	public Main(){
		
		//ventanaPrincipal = new MainWindow();
		//ventanaPrincipal.setVisible(true);
		
		//loginview = new LoginView();
		//loginview.setVisible(true);
		
		chatview = new ChatView();
		chatview.setVisible(true);
		
				
		
	}
	
	public static void main(String[] args){
		Main main = new Main();
	}
}
