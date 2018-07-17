package views.chat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelChatList extends JPanel {
	
	//private JList ChatList;
	//private DefaultListModel model2;
	private JButton PruebaBtn;
	private ItemPersona itempersona;
	private ItemPersona itempersona2;
	private ItemPersona itempersona3;
	
	private JScrollPane scrollLista;
	
	
	
	
	
	
	public PanelChatList() {
		
				
		
		
	}
	
	public void initView() {
		this.setLayout(null);
		
		Dimension dimen = this.getSize();
		int ANCHOP = (int)dimen.getWidth();
		int ALTOP = (int)dimen.getHeight();
		
		int partANCHOP = ANCHOP / 10;
		int partALTOP = ALTOP / 10;
		
		
		//this.setBackground(Color.BLUE);
		
		scrollLista = new JScrollPane();
		scrollLista.setBounds(10 , 10 , ANCHOP - 10, ALTOP - 10);
			
		
		itempersona = new ItemPersona(100, 100);
		itempersona2 = new ItemPersona(100, 100);
		itempersona3 = new ItemPersona(100, 100);
		
		//itempersona.setVisible(true);
		//itempersona.initView(20 , 20);
		
				
		scrollLista.add(new JButton("hola"));
		/*scrollLista.add(new JButton("hola2"));
		scrollLista.add(new JButton("hola3"));*/
		
		
		this.add(scrollLista);
		/*modelo.addElement(itempersona);
		modelo.addElement(itempersona);
		modelo.addElement(itempersona);
		modelo.addElement(itempersona);
		modelo.addElement(itempersona);
		modelo.addElement(itempersona);*/
		
		//System.out.println(" "+ ANCHOP + " "+ ALTOP);
		
		
	}
	

}
