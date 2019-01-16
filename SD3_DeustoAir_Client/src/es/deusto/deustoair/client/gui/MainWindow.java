package es.deusto.deustoair.client.gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

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

public class MainWindow {
	
	private static final long serialVersionUID = 1L;
	private MainController controller;
	
	private JFrame frame;
	private JTextField tfFrom;
	private JTextField tfTo;
	private JTextField tfDepart;
	private JTextField tfReturn;
	private DefaultListModel<String> SearchList = new DefaultListModel<String>();
	private JScrollPane scrollSearch = new JScrollPane();
	private JLabel lblFrom;
	private JLabel lblTo;
	private JLabel lblDepart;
	private JLabel lblReturn;
	private JButton btnNewButton;
	private JList list;
	
	
	
	
	
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
		
		lblFrom = new JLabel("From");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFrom.setBounds(12, 13, 57, 33);
		frame.getContentPane().add(lblFrom);
		
		tfFrom = new JTextField();
		tfFrom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfFrom.setBounds(12, 45, 140, 22);
		frame.getContentPane().add(tfFrom);
		tfFrom.setColumns(10);
		
		lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTo.setBounds(185, 13, 57, 33);
		frame.getContentPane().add(lblTo);
		
		tfTo = new JTextField();
		tfTo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfTo.setColumns(10);
		tfTo.setBounds(185, 45, 140, 22);
		frame.getContentPane().add(tfTo);
		
		lblDepart = new JLabel("Depart");
		lblDepart.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDepart.setBounds(353, 13, 84, 33);
		frame.getContentPane().add(lblDepart);
		
		tfDepart = new JTextField();
		tfDepart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfDepart.setColumns(10);
		tfDepart.setBounds(353, 45, 140, 22);
		frame.getContentPane().add(tfDepart);
		
		lblReturn = new JLabel("Return");
		lblReturn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblReturn.setBounds(510, 13, 94, 33);
		frame.getContentPane().add(lblReturn);
		
		tfReturn = new JTextField();
		tfReturn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfReturn.setColumns(10);
		tfReturn.setBounds(510, 45, 140, 22);
		frame.getContentPane().add(tfReturn);
		
		JButton btnSearch = new JButton("Search!");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonSearchActionPerformed(evt);
			}
		});
		btnSearch.setBounds(675, 19, 140, 49);
		frame.getContentPane().add(btnSearch);
		
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
		
		btnNewButton = new JButton("Buy");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonSelectActionPerformed(evt);
			}
		});
		btnNewButton.setBounds(692, 493, 123, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnMyReservations = new JButton("My Reservations");
		btnMyReservations.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMyReservations.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonReservActionPerformed(evt);
			}
		});
		btnMyReservations.setBounds(497, 493, 168, 33);
		frame.getContentPane().add(btnMyReservations);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(353, 493, 123, 33);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				buttonRegActionPerformed(evt);
			}
		});
		
		frame.setVisible(true);
	}
	//update list
	private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("* Main Button");
		SearchList.clear();
		List<String> searchs = controller.getSearch(tfFrom.getText(),tfTo.getText(),tfDepart.getText(),tfReturn.getText());
		for (int i = 0; i < searchs.size(); i++) {
			SearchList.addElement(searchs.get(i));
		}
		 
		
		
		
	}
	private void buttonSelectActionPerformed(java.awt.event.ActionEvent evt) {
		System.out.println("* Select Button");
		if (!list.isSelectionEmpty()) {
			new PaymentWindow(list.getSelectedValue());
			
		} else {
			System.out.println("* No selection");
		}
		
	}
	
	private void buttonReservActionPerformed(java.awt.event.ActionEvent evt) {
		new ReservationWindow(this.controller);
		
	}
	
	private void buttonRegActionPerformed(java.awt.event.ActionEvent evt) {
		new RegisterWindow(this.controller);
		
	}
}
