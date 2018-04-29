package main;

import views.MainWindow;

public class Main {
	
	private MainWindow ventanaPrincipal;

	public Main(){
		
		ventanaPrincipal = new MainWindow();
		ventanaPrincipal.setVisible(true);
	}
	
	public static void main(String[] args){
		Main main = new Main();
	}
}
