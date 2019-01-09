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

public class ReservationWindow {
	private Object flight;
	private JFrame frame;
	private JPanel OptPanelC;
	private JPanel OptPanelP;

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
		
		OptPanelP = new JPanel();
		OptPanelP.setBounds(21, 95, 450, 360);
		OptPanelP.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "PayPal Info"));
		OptPanelP.setVisible(false);
		frame.getContentPane().add(OptPanelP);
		
		OptPanelC = new JPanel();
		OptPanelC.setBounds(21, 95, 450, 360);
		OptPanelC.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Credit Info"));
		OptPanelC.setVisible(false);
		frame.getContentPane().add(OptPanelC);
		
		frame.setVisible(true);
	}
}
