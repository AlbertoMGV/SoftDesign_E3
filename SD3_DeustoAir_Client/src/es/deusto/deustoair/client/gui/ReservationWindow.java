package es.deusto.deustoair.client.gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import es.deusto.deustoair.client.controller.MainController;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ReservationWindow {
	
	private static final long serialVersionUID = 1L;
	private MainController controller;
	
	private JFrame frame;
	private JTextField tfFrom;
	private DefaultListModel<String> SearchList = new DefaultListModel<String>();
	private JScrollPane scrollSearch = new JScrollPane();
	private JLabel lblFrom;
	private JButton btnNewButton;
	private JList list;
	private JButton btnNewButton_1;
	private JButton btnClose;
	private JTextField textField;
	
	
	public ReservationWindow(MainController controller) {
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
		frame.setTitle("Deusto Air - Reservations");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblFrom = new JLabel("User Email");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFrom.setBounds(12, 13, 303, 33);
		frame.getContentPane().add(lblFrom);
		
		tfFrom = new JTextField();
		tfFrom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfFrom.setBounds(12, 45, 303, 22);
		frame.getContentPane().add(tfFrom);
		tfFrom.setColumns(10);
		
		JPanel SearchPanel = new JPanel();
		SearchPanel.setBounds(12, 80, 800, 400);
		SearchPanel.setLayout(new java.awt.GridLayout(1, 2));
		SearchPanel.setBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EtchedBorder(), "Search Flights"));
		frame.getContentPane().add(SearchPanel);
		
		
		list = new JList();
		list.setModel(SearchList);
		list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		scrollSearch.setViewportView(list);
		
		SearchPanel.add(scrollSearch, java.awt.BorderLayout.CENTER);
		
		btnNewButton = new JButton("Info");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonSelectActionPerformed(evt);
			}
		});
		btnNewButton.setBounds(692, 493, 123, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnMyReservations = new JButton("Delete");
		btnMyReservations.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMyReservations.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
			}
		});
		btnMyReservations.setBounds(542, 493, 123, 33);
		frame.getContentPane().add(btnMyReservations);
		
		btnNewButton_1 = new JButton("Check Reservations");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonReservActionPerformed(evt);
			}
		});
		btnNewButton_1.setBounds(611, 24, 200, 43);
		frame.getContentPane().add(btnNewButton_1);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setBounds(407, 493, 123, 33);
		frame.getContentPane().add(btnClose);
		
		JLabel lblUserPass = new JLabel("User Pass");
		lblUserPass.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUserPass.setBounds(327, 13, 254, 33);
		frame.getContentPane().add(lblUserPass);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(327, 45, 254, 22);
		frame.getContentPane().add(textField);
		
		frame.setVisible(true);
	}
	private void buttonSelectActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("* Select Button");
		if (!list.isSelectionEmpty()) {
			new InfoWindow(list.getSelectedValue());
			
		} else {
			System.out.println("* No selection");
		}
		
	}
	private void buttonReservActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("* Main Button");
		SearchList.clear();
		ArrayList<String> searchs = controller.getReservations(tfFrom.getText());
		for (int i = 0; i < searchs.size(); i++) {
			SearchList.addElement(searchs.get(i));
		}
		
		
	}
}
