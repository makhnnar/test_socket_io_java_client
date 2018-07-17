package views.chat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import utilities.HintTextField;
import utilities.Values;

public class ChatView extends JFrame{
			
		
		private JList ChatField;
		
		private DefaultListModel model;
		private JTextField EntradaChat;
		private JButton SendBtn;
		private JScrollPane PaneList;
		private JScrollPane PaneField;
		private PanelChatList panelchatlist;
		private PanelChatField panelchatfield;
		private PanelChatEntry panelchatentry;
		
		
		
		
		public ChatView(){
			//super("GridBagLayout");
			Dimension display = Toolkit.getDefaultToolkit().getScreenSize(); 
			Values.ALTO = (int)display.getHeight()-1;
			Values.ANCHO = (int)display.getWidth()-30;
			
			Values.PartALTO = Values.ALTO / 10;
			Values.PartANCHO = Values.ANCHO / 10;
			
			
			this.setSize(Values.ANCHO, Values.ALTO);
			
			this.setTitle("Chat");
			//new BoxLayout(this, BoxLayout.X_AXIS);
			this.setLayout(null);
			this.setResizable(false);
			
			panelchatlist = new PanelChatList();
			panelchatlist.setVisible(true);
			//panelchatlist.setSize(PartANCHO * 3, PartALTO * 10);
			//panelchatlist.setAlignmentX(LEFT_ALIGNMENT);
			panelchatlist.setBounds(0, 0, Values.PartANCHO * 3, Values.PartALTO * 10);
			panelchatlist.initView();
			this.add(panelchatlist);
			
			panelchatfield = new PanelChatField();
			panelchatfield.setVisible(true);
			//panelchatfield.setAlignmentX(RIGHT_ALIGNMENT);
			panelchatfield.setBounds(Values.PartANCHO * 3, 0, Values.PartANCHO * 7 , Values.PartALTO * 8);
			this.add(panelchatfield);
			
			panelchatentry = new PanelChatEntry();
			panelchatentry.setBounds(Values.PartANCHO * 3, Values.PartALTO * 8, Values.PartANCHO * 8, Values.PartALTO * 2);
			panelchatentry.initView();
			this.add(panelchatentry);
			
			
			
			
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			
			
			
			
			
			
			
			
			
			//GridBagConstraints gbc = new GridBagConstraints(); //restricciones de comportamiento de los elementos en la ventana
			
			/*model = new DefaultListModel();
			model.addElement("elemento1");
			model.addElement("elemento2");
			
			ChatField = new JList(model);
			
			PaneField = new JScrollPane(ChatField);
			
						
			
			model2 = new DefaultListModel();
			model2.addElement("elemento1");
			model2.addElement("elemento2");
			
			
			
			
			
			
			
			
			EntradaChat = new JTextField();
			
			
			
			
			
			SendBtn = new JButton("Send");
			
			
			
			
			
			
			/*gbc.gridx = 1; 
			gbc.gridy = 0; 
			gbc.gridwidth = 2; 
			gbc.gridheight = 1; 
			//gbc.weightx = 1.0; 
			gbc.weighty = 1.0; 
			gbc.fill = GridBagConstraints.HORIZONTAL;
			add(EntradaChat,gbc);
*/			
			
			
			}

	}



