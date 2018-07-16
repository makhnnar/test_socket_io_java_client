package views.chat;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import utilities.HintTextField;

public class ChatView extends JFrame{
			
		private JList ChatList;
		private JList ChatField;
		private DefaultListModel model;
		private DefaultListModel model2;
		private JTextField EntradaChat;
		private JButton SendBtn;
		private JScrollPane PaneList;
		private JScrollPane PaneField;
			
		
		public ChatView(){
			super("GridBagLayout");
			this.setSize(800, 800);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("Chat");
			this.setLayout(new GridBagLayout());
			
			GridBagConstraints gbc = new GridBagConstraints(); //restricciones de comportamiento de los elementos en la ventana
			
			model = new DefaultListModel();
			model.addElement("elemento1");
			model.addElement("elemento2");
			
			ChatField = new JList(model);
			
			PaneField = new JScrollPane(ChatField);
			
			gbc.gridx = 2;
			gbc.gridy = 0;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.weighty = 1.0;
			// El botón 1 debe ocupar la posición NORTH de su celda 
			gbc.anchor = GridBagConstraints.NORTH;
			// El botón 1 no debe estirarse. Habíamos cambiado este valor en el
			// area de texto, asi que lo restauramos.
			gbc.fill = GridBagConstraints.NONE;
			this.add (PaneField,gbc);
			// Restauramos valores por defecto
			gbc.anchor = GridBagConstraints.CENTER; 
			gbc.weighty = 0.0; 
			
						
			
			model2 = new DefaultListModel();
			model2.addElement("elemento1");
			model2.addElement("elemento2");
			
			ChatList = new JList(model2);
			
			PaneList = new JScrollPane(ChatList);
			
			
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 2;
			gbc.gridheight = 2;
			// El area de texto debe estirarse en ambos sentidos. Ponemos el campo fill.
			gbc.fill = GridBagConstraints.BOTH;
			gbc.weighty = 1.0; 
			this.add (PaneList,gbc); 
			gbc.weighty = 0.0;
			
			EntradaChat = new JTextField();
			
			
			gbc.gridx = 2;
			gbc.gridy = 1; 
			gbc.gridwidth = 1; 
			gbc.gridheight = 1; 
			gbc.weighty = 1.0; 
			// El boton 2 debe ocupar la posición NORTH de su celda. 
			gbc.anchor = GridBagConstraints.NORTH;
			this.getContentPane().add (EntradaChat,gbc);
			// Restauramos valores por defecto.
			gbc.weighty = 0.0; 
			gbc.anchor = GridBagConstraints.CENTER; 
			
			
			SendBtn = new JButton("Send");
			
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.gridwidth = 1; 
			gbc.gridheight = 1; 
			this.add (SendBtn, gbc); 
			
			
			
			
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



