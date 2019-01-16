package es.deusto.deustoair.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import es.deusto.deustoair.client.controller.MainController;
import es.deusto.deustoair.server.data.dto.AirportDTO;
import es.deusto.deustoair.server.data.dto.FlightDTO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class RegisterWindow {

	private JFrame frame;
	private MainController controller;
	private JTextField txemail;
	private JTextField txpass;
	private JTextField txrpass;
	private JTextField txairport;
	ButtonGroup bgroup;

	
	public RegisterWindow(MainController controller) {
		this.controller = controller;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 322, 247);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("DeustoAir - Register");
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(12, 13, 97, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPass = new JLabel("Pass:");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPass.setBounds(12, 42, 97, 16);
		frame.getContentPane().add(lblPass);
		
		JLabel lblRepeatpass = new JLabel("RepeatPass:");
		lblRepeatpass.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRepeatpass.setBounds(12, 71, 97, 16);
		frame.getContentPane().add(lblRepeatpass);
		
		txemail = new JTextField();
		txemail.setBounds(121, 10, 183, 22);
		frame.getContentPane().add(txemail);
		txemail.setColumns(10);
		
		txpass = new JTextField();
		txpass.setColumns(10);
		txpass.setBounds(121, 39, 183, 22);
		frame.getContentPane().add(txpass);
		
		txrpass = new JTextField();
		txrpass.setColumns(10);
		txrpass.setBounds(121, 68, 183, 22);
		frame.getContentPane().add(txrpass);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AirportDTO homeAir = new AirportDTO(txairport.getText());
				if (txpass.getText().equals(txrpass.getText())) {
					if (controller.register(txemail.getText(),txpass.getText(),bgroup.getSelection().getActionCommand(),homeAir)) {
						System.out.println("* REGISTERED");
					} else {
						System.out.println("* ERROR");
					}
				}
				
					
			}
		});
		btnRegister.setBounds(207, 174, 97, 25);
		frame.getContentPane().add(btnRegister);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setBounds(98, 174, 97, 25);
		frame.getContentPane().add(btnClose);
		
		JLabel lblHomeAirportCode = new JLabel("Home Airport");
		lblHomeAirportCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHomeAirportCode.setBounds(12, 103, 97, 16);
		frame.getContentPane().add(lblHomeAirportCode);
		
		txairport = new JTextField();
		txairport.setColumns(10);
		txairport.setBounds(121, 100, 183, 22);
		frame.getContentPane().add(txairport);
		
		JLabel lblNewLabel = new JLabel("Auth Method");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 132, 97, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnGoogle = new JRadioButton("Google");
		rdbtnGoogle.setActionCommand(rdbtnGoogle.getText());
		rdbtnGoogle.setBounds(121, 131, 75, 25);
		frame.getContentPane().add(rdbtnGoogle);
		
		JRadioButton rdbtnFacebook = new JRadioButton("Facebook");
		rdbtnFacebook.setBounds(200, 131, 97, 25);
		frame.getContentPane().add(rdbtnFacebook);
		frame.setResizable(false);
		
		bgroup = new ButtonGroup();	
		bgroup.add(rdbtnGoogle);
		bgroup.add(rdbtnFacebook);
		
		
		
		
		
		
		frame.setVisible(true);
	}
}
