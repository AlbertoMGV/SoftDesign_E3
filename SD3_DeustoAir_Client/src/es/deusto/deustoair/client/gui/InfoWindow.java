package es.deusto.deustoair.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class InfoWindow {
	private Object flight;
	private JFrame frame;
	private JButton btnPay;
	private JLabel lblNewLabel;

	
	public InfoWindow(Object object) {
		this.flight=object.toString();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Deusto Air - Info");
		frame.setBounds(100, 100, 500, 271);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPaymentMethod = new JLabel("Reservation Info");
		lblPaymentMethod.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPaymentMethod.setBounds(21, 13, 450, 54);
		frame.getContentPane().add(lblPaymentMethod);
		
		btnPay = new JButton("Close");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("* Close");
				frame.dispose();
			}
		});
		btnPay.setBounds(374, 200, 97, 25);
		frame.getContentPane().add(btnPay);
		
		lblNewLabel = new JLabel(flight.toString());
		lblNewLabel.setBounds(21, 55, 450, 132);
		frame.getContentPane().add(lblNewLabel);
		
		frame.setVisible(true);
	}
}
