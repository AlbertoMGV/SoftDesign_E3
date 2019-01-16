package es.deusto.deustoair.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PaymentWindow {
	private Object flight;
	private JFrame frame;
	private JPanel OptPanelC;
	private JPanel OptPanelP;
	private JPanel OptPanelU;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JButton btnPay;
	private JTextField tfEmail;
	private JTextField tfpass;
	private JLabel lblNumber;
	private JLabel lblCvv;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblExpiry;
	private JTextField textField_2;
	private JLabel lblSeats;
	private JTextField textField_3;
	private JCheckBox chckbxPayPal;
	private JCheckBox chckbxCredit;
	private JTextField textField_4;
	private JButton btnClose;
	private JLabel lblPass;
	private JTextField textField_5;

	public PaymentWindow(Object object) {
		this.flight = object;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Deusto Air - Payment");
		frame.setBounds(100, 100, 500, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		chckbxCredit = new JCheckBox("Credit");
		chckbxCredit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCredit.setBounds(138, 183, 113, 25);
		frame.getContentPane().add(chckbxCredit);
		chckbxCredit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxCredit.isSelected()) {
					
					chckbxPayPal.setSelected(false);
					OptPanelP.setVisible(false);
					OptPanelC.setVisible(true);
				}
				
			}
		});
		
		
		chckbxPayPal = new JCheckBox("PayPal");
		chckbxPayPal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxPayPal.setBounds(21, 183, 113, 25);
		chckbxPayPal.setSelected(true);
		frame.getContentPane().add(chckbxPayPal);
		chckbxPayPal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxPayPal.isSelected()) {
					
					chckbxCredit.setSelected(false);
					OptPanelC.setVisible(false);
					OptPanelP.setVisible(true);
					
					
					System.out.println("* PPPP");
					
				}
				
			}
		});
		
		
		
		JLabel lblPaymentMethod = new JLabel(flight.toString());
		lblPaymentMethod.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPaymentMethod.setBounds(21, 13, 450, 54);
		frame.getContentPane().add(lblPaymentMethod);
		
		btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("* Pay");
				if (chckbxCredit.isSelected() || chckbxPayPal.isSelected()) {
					
					//pay();
					
				} else {
					System.out.println("* Choose Payment method");
				}
			}
		});
		btnPay.setBounds(374, 342, 97, 25);
		frame.getContentPane().add(btnPay);
		
		lblSeats = new JLabel("Seats Amount:");
		lblSeats.setBounds(21, 346, 87, 16);
		frame.getContentPane().add(lblSeats);
		
		textField_3 = new JTextField();
		textField_3.setBounds(120, 343, 39, 22);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		OptPanelC = new JPanel();
		OptPanelC.setBounds(21, 217, 450, 112);
		frame.getContentPane().add(OptPanelC);
		OptPanelC.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Credit Info"));
		OptPanelC.setVisible(false);
		OptPanelC.setLayout(null);
		
		lblNumber = new JLabel("Number:");
		lblNumber.setBounds(12, 23, 56, 16);
		OptPanelC.add(lblNumber);
		
		lblCvv = new JLabel("CVV:");
		lblCvv.setBounds(12, 52, 70, 16);
		OptPanelC.add(lblCvv);
		
		textField = new JTextField();
		textField.setBounds(80, 20, 116, 22);
		OptPanelC.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 49, 116, 22);
		OptPanelC.add(textField_1);
		textField_1.setColumns(10);
		
		lblExpiry = new JLabel("Expiry:");
		lblExpiry.setBounds(12, 81, 56, 16);
		OptPanelC.add(lblExpiry);
		
		textField_2 = new JTextField();
		textField_2.setBounds(80, 81, 116, 22);
		OptPanelC.add(textField_2);
		textField_2.setColumns(10);
		
		OptPanelP = new JPanel();
		OptPanelP.setBounds(21, 217, 450, 112);
		frame.getContentPane().add(OptPanelP);
		OptPanelP.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "PayPal Info"));
		OptPanelP.setVisible(true);
		OptPanelP.setLayout(null);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(12, 35, 56, 16);
		OptPanelP.add(lblEmail);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(12, 64, 70, 16);
		OptPanelP.add(lblPassword);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(89, 32, 116, 22);
		OptPanelP.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfpass = new JTextField();
		tfpass.setBounds(89, 61, 116, 22);
		OptPanelP.add(tfpass);
		tfpass.setColumns(10);
		
		OptPanelU = new JPanel();
		OptPanelU.setBounds(21, 80, 450, 94);
		frame.getContentPane().add(OptPanelU);
		OptPanelU.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "DeustAir User"));
		OptPanelU.setVisible(true);
		OptPanelU.setLayout(null);
		
		JLabel lblEmail_1 = new JLabel("Email:");
		lblEmail_1.setBounds(12, 29, 56, 16);
		OptPanelU.add(lblEmail_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(64, 26, 190, 22);
		OptPanelU.add(textField_4);
		textField_4.setColumns(10);
		
		lblPass = new JLabel("Pass:");
		lblPass.setBounds(12, 61, 56, 16);
		OptPanelU.add(lblPass);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(64, 58, 190, 22);
		OptPanelU.add(textField_5);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setBounds(265, 342, 97, 25);
		frame.getContentPane().add(btnClose);
		
		frame.setVisible(true);
	}
}
