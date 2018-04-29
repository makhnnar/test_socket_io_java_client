package views;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import interfaces.OnMessageListener;
import presenters.MessagePresenter;
import utilities.Values;


public class MainWindow extends JFrame implements ActionListener, OnMessageListener{

	private JButton[] rooms;
	private JButton btn_room;
	private JButton btn_gen;
	private JTextField campo_nickname;
	private JTextField campo_message;
	private JTextArea areaMSG;
	private MessagePresenter presenter;
	

	private static final long serialVersionUID = 1L;
	
	public MainWindow(){
		presenter = new MessagePresenter(this);
		Dimension display = Toolkit.getDefaultToolkit().getScreenSize(); 
		Values.ALTO = (int)display.getHeight()-1;
		Values.ANCHO = (int)display.getWidth()-30;
		Values.DISTANCE = (Values.ANCHO - 200)/ 9 ;
		this.setSize(Values.ANCHO,Values.ALTO);
		this.setLayout(null);
		this.setResizable(false);
		this.setTitle(Values.TITLE);
		this.Componentes();
		//this.setVisible(true);//lo debemos invocar al querer visualizar la ventana
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void Componentes(){
		rooms = new JButton[9];
		int spacesX = 20;
		int spacesY = 20;
		for(int i=0;i<9;i++){
			rooms[i] = new JButton("ROOM "+(i+1));
			rooms[i].setBounds(spacesX, spacesY, Values.DISTANCE, Values.ALTO_BTN);
			rooms[i].addActionListener(this);
			this.add(rooms[i]);
			spacesX = spacesX+Values.DISTANCE+20;
		}
		spacesY = spacesY +Values.ALTO_BTN + 20; 
		areaMSG = new JTextArea();
		areaMSG.setBounds(20, spacesY, Values.ANCHO-40, Values.ALTO - spacesY * 3);
		this.add(areaMSG);
		spacesY = spacesY + (Values.ALTO - spacesY * 3) + 20;
		spacesX = 20;
		campo_nickname = new JTextField("NICKNAME");
		campo_nickname.setBounds(spacesX, spacesY, Values.DISTANCE, Values.ALTO_BTN);
		this.add(campo_nickname);
		spacesX = spacesX+Values.DISTANCE+20;
		campo_message = new JTextField("MENSAJE");
		campo_message.setBounds(spacesX, spacesY, Values.DISTANCE*6, Values.ALTO_BTN);
		this.add(campo_message);
		spacesX = spacesX+Values.DISTANCE*6+20;
		btn_gen = new JButton("SEND GEN");
		btn_gen.setBounds(spacesX, spacesY, Values.DISTANCE, Values.ALTO_BTN);
		btn_gen.addActionListener(this);
		this.add(btn_gen);
		spacesX = spacesX+Values.DISTANCE+20;
		btn_room = new JButton("SEND ROOM");
		btn_room.setBounds(spacesX, spacesY, Values.DISTANCE, Values.ALTO_BTN);
		btn_room.addActionListener(this);
		this.add(btn_room);
	}

	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource().equals(btn_gen)){
			presenter.sendGeneralMessage(campo_nickname.getText(), campo_message.getText());
		}
		if(ev.getSource().equals(btn_room)){
			presenter.joinToSelectedRoom("1");
			presenter.sendRoomMessage("1", campo_nickname.getText(), campo_message.getText());
		}
	}

	public void onMessageRecieved(String msg) {
		areaMSG.append(msg+" \n ");
	}
	
	
}
