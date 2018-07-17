package views.chat;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelChatEntry extends JPanel{
	
	
	private JButton PruebaBtn4;
	private JTextField entryField;
	
	PanelChatEntry(){
		
	}
	public void initView() {
		this.setLayout(null);
		this.setBackground(Color.RED);
		Dimension dimen = this.getSize();
		int ANCHOP = (int)dimen.getWidth();
		int ALTOP = (int)dimen.getHeight();
		
		int partANCHOP = ANCHOP / 10;
		int partALTOP = ALTOP / 10;
		
		entryField = new JTextField();
		entryField.setBounds(10, 10, partANCHOP * 7 - 20, partALTOP * 7);
		this.add(entryField);
		
		PruebaBtn4 = new JButton("hola3");
		PruebaBtn4.setBounds(partANCHOP * 7 , 10, partANCHOP * 2 - 35, partALTOP * 7);
		this.add(PruebaBtn4);
		//
	//	System.out.println(""+ANCHOP+" "+ ALTOP+ " "+partANCHOP+ " "+ partALTOP);
		//+" "+dimen.getHeight()+" "+dimen.getWidth()
		
		
	}

}
