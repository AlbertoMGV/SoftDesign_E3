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

public class ReservationWindow {
	private Object flight;
	private JFrame frame;
	private JPanel OptPanelC;
	private JPanel OptPanelP;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JButton btnPay;
	private JTextField tfEmail;
	private JTextField tfpass;
	private JLabel label;
	private JLabel lblCvv;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblExpiry;
	private JTextField textField_2;
	private JLabel lblSeats;
	private JTextField textField_3;

	public ReservationWindow(Object object) {
		this.flight = object;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle(flight.toString());
		frame.setBounds(100, 100, 500, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox chckbxPayPal = new JCheckBox("PayPal");
		chckbxPayPal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxPayPal.setBounds(21, 61, 113, 25);
		frame.getContentPane().add(chckbxPayPal);
		chckbxPayPal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxPayPal.isSelected()) {
					System.out.println("Paypal");
					OptPanelC.setVisible(false);
					OptPanelP.setVisible(true);
					
					
				}
				
			}
		});
		
		JCheckBox chckbxCredit = new JCheckBox("Credit");
		chckbxCredit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCredit.setBounds(174, 61, 113, 25);
		frame.getContentPane().add(chckbxCredit);
		chckbxCredit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxCredit.isSelected()) {
					System.out.println("Credit");
					OptPanelP.setVisible(false);
					OptPanelC.setVisible(true);
				}
				
			}
		});
		
		JLabel lblPaymentMethod = new JLabel("Payment Method");
		lblPaymentMethod.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPaymentMethod.setBounds(21, 13, 152, 39);
		frame.getContentPane().add(lblPaymentMethod);
		
		OptPanelC = new JPanel();
		OptPanelC.setBounds(21, 95, 450, 166);
		OptPanelC.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Credit Info"));
		OptPanelC.setVisible(false);
		frame.getContentPane().add(OptPanelC);
		OptPanelC.setLayout(null);
		
		label = new JLabel("Email:");
		label.setBounds(12, 48, 56, 16);
		OptPanelC.add(label);
		
		lblCvv = new JLabel("CVV:");
		lblCvv.setBounds(12, 75, 70, 16);
		OptPanelC.add(lblCvv);
		
		textField = new JTextField();
		textField.setBounds(80, 43, 116, 22);
		OptPanelC.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 73, 116, 22);
		OptPanelC.add(textField_1);
		textField_1.setColumns(10);
		
		lblExpiry = new JLabel("Expiry:");
		lblExpiry.setBounds(12, 104, 56, 16);
		OptPanelC.add(lblExpiry);
		
		textField_2 = new JTextField();
		textField_2.setBounds(80, 101, 116, 22);
		OptPanelC.add(textField_2);
		textField_2.setColumns(10);
		
		btnPay = new JButton("Pay");
		btnPay.setBounds(362, 274, 97, 25);
		frame.getContentPane().add(btnPay);
		
		OptPanelP = new JPanel();
		OptPanelP.setBounds(21, 95, 450, 166);
		frame.getContentPane().add(OptPanelP);
		OptPanelP.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "PayPal Info"));
		OptPanelP.setVisible(false);
		OptPanelP.setLayout(null);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(12, 38, 56, 16);
		OptPanelP.add(lblEmail);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(12, 71, 70, 16);
		OptPanelP.add(lblPassword);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(89, 35, 116, 22);
		OptPanelP.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfpass = new JTextField();
		tfpass.setBounds(89, 68, 116, 22);
		OptPanelP.add(tfpass);
		tfpass.setColumns(10);
		
		lblSeats = new JLabel("Seats Amount:");
		lblSeats.setBounds(21, 274, 87, 16);
		frame.getContentPane().add(lblSeats);
		
		textField_3 = new JTextField();
		textField_3.setBounds(120, 274, 39, 22);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		frame.setVisible(true);
	}
}
