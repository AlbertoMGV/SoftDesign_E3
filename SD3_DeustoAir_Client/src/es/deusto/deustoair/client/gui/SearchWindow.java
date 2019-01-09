package es.deusto.deustoair.client.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import es.deusto.deustoair.client.controller.MainController;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SearchWindow {
	
	private static final long serialVersionUID = 1L;
	private MainController controller;
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnSearch;
	private ArrayList<String> data;



	public SearchWindow(MainController controller) {
		this.controller = controller;
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(400, 400, 750, 300);
		frame.setResizable(false);
		frame.setTitle("DeustoAir");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(31, 215, 146, 25);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFrom.setBounds(31, 176, 67, 34);
		frame.getContentPane().add(lblFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTo.setBounds(204, 181, 78, 25);
		frame.getContentPane().add(lblTo);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(206, 215, 146, 25);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(365, 215, 90, 25);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(473, 215, 90, 25);
		frame.getContentPane().add(textField_3);
		
		JLabel lblDepart = new JLabel("Depart");
		lblDepart.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDepart.setBounds(365, 181, 78, 25);
		frame.getContentPane().add(lblDepart);
		
		JLabel lblReturn = new JLabel("Return");
		lblReturn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReturn.setBounds(473, 181, 78, 25);
		frame.getContentPane().add(lblReturn);
		
		btnSearch = new JButton("Search!");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				data.add(lblFrom.getText());
				data.add(lblTo.getText());
				data.add(lblDepart.getText());
				data.add(lblReturn.getText());				
				new MainWindow(data,controller);
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSearch.setBounds(575, 181, 146, 56);
		frame.getContentPane().add(btnSearch);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Image", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(31, 13, 690, 149);
		frame.getContentPane().add(panel);
		
		
	}
}
