package es.deusto.deustoair.client.gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import es.deusto.deustoair.client.controller.MainController;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {
	
	private static final long serialVersionUID = 1L;
	private MainController controller;
	
	private JFrame frame;
	private JTextField tfFrom;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	
	
	
	
	public MainWindow(MainController controller) {
		this.controller = controller;
		initialize();
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 845, 594);
		
		frame.setResizable(false);
		frame.setTitle("Deusto Air");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFrom.setBounds(12, 13, 57, 33);
		frame.getContentPane().add(lblFrom);
		
		tfFrom = new JTextField();
		tfFrom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfFrom.setBounds(12, 45, 140, 22);
		frame.getContentPane().add(tfFrom);
		tfFrom.setColumns(10);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTo.setBounds(185, 13, 57, 33);
		frame.getContentPane().add(lblTo);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(185, 45, 140, 22);
		frame.getContentPane().add(textField);
		
		JLabel lblDepart = new JLabel("Depart");
		lblDepart.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDepart.setBounds(353, 13, 84, 33);
		frame.getContentPane().add(lblDepart);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(353, 45, 140, 22);
		frame.getContentPane().add(textField_1);
		
		JLabel lblReturn = new JLabel("Return");
		lblReturn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblReturn.setBounds(510, 13, 94, 33);
		frame.getContentPane().add(lblReturn);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(510, 45, 140, 22);
		frame.getContentPane().add(textField_2);
		
		JButton btnSearch = new JButton("Search!");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSearch.setBounds(675, 19, 140, 49);
		frame.getContentPane().add(btnSearch);
		
		frame.setVisible(true);
	}
}
