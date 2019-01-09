package es.deusto.deustoair.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;

public class ReservationWindow {
	private Object flight;
	private JFrame frame;

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
		frame.setBounds(100, 100, 500, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox chckbxPayPal = new JCheckBox("PayPal");
		chckbxPayPal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxPayPal.setBounds(21, 61, 113, 25);
		frame.getContentPane().add(chckbxPayPal);
		
		JCheckBox chckbxCredit = new JCheckBox("Credit");
		chckbxCredit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxCredit.setBounds(174, 61, 113, 25);
		frame.getContentPane().add(chckbxCredit);
		
		JLabel lblPaymentMethod = new JLabel("Payment Method");
		lblPaymentMethod.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPaymentMethod.setBounds(21, 13, 152, 39);
		frame.getContentPane().add(lblPaymentMethod);
		frame.setVisible(true);
	}
}
