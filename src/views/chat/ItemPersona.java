package views.chat;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ItemPersona extends JPanel {
	
	private JButton pruebaBoton ;
	private JLabel hola;
	
	
	
	public ItemPersona(int ancho, int alto){
		
		this.setLayout(null);
		this.setBackground(Color.MAGENTA);
		this.setSize(ancho, alto);
		
		hola = new JLabel("holaa");
		hola.setBounds(0, 0, ancho -1, alto -1);
		this.add(hola);
		
		System.out.println(" "+ancho+" "+alto);
		
		
	}
	

}
