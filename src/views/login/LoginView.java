package views.login;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import utilities.HintTextField;
import utilities.Values;


public class LoginView extends JFrame{
	
	private JTextField LoginPhone;
	private JTextField LoginPass;
	private JButton LoginBtn;
		
	
	public LoginView(){
		super("GridBagLayout");
		Dimension display = Toolkit.getDefaultToolkit().getScreenSize(); 
		Values.ALTO = (int)display.getHeight()-1;
		Values.ANCHO = (int)display.getWidth()-30;
		this.setSize(Values.ALTO , Values.ALTO);
		this.setTitle("Login");
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints(); //restricciones de comportamiento de los elementos en la ventana
		LoginPhone = new  HintTextField("Phone Number");
		LoginPass = new HintTextField("Password");
		LoginBtn = new JButton("Login");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			
		gbc.gridx = 1; 
		gbc.gridy = 0; 
		gbc.gridwidth = 2; 
		gbc.gridheight = 1; 
		//gbc.weightx = 1.0; 
		gbc.weighty = 1.0; 
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(LoginPhone,gbc);
		
		gbc.gridx = 1; 
		gbc.gridy = 1; 
		gbc.gridwidth = 2; 
		gbc.gridheight = 1; 
		//gbc.weightx = 1.0; 
		gbc.weighty = 1.0; 
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(LoginPass,gbc);
		
		gbc.gridx = 1; 
		gbc.gridy = 2; 
		gbc.gridwidth = 2; 
		gbc.gridheight = 1; 
		//gbc.weightx = 1.0; 
		gbc.weighty = 1.0; 
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(LoginBtn,gbc);
		
		
		
		}

}
