package views.chat;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelChatField extends JPanel{
	
	private JButton PruebaBtn2;
	private JButton PruebaBtn3;
	
		
	
	public PanelChatField() {
		
		new BoxLayout(this, BoxLayout.X_AXIS);
		
		
		
		this.setBackground(Color.RED);
		
		
		
		PruebaBtn2 = new JButton("hola1");
		PruebaBtn2.setAlignmentX(PanelChatField.CENTER_ALIGNMENT);
		this.add(PruebaBtn2);
		
		PruebaBtn3= new JButton("hola2");
		PruebaBtn3.setAlignmentX(PanelChatField.LEFT_ALIGNMENT);
		this.add(PruebaBtn3);
		
		
		
	}

}
