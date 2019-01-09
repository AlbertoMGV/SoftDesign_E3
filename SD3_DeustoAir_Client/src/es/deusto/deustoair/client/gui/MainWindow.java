package es.deusto.deustoair.client.gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;

import es.deusto.deustoair.client.controller.MainController;

public class MainWindow {
	
	private static final long serialVersionUID = 1L;
	private MainController controller;
	
	private JFrame frame;

	

	/**
	 * Create the application.
	 * @param data 
	 * @param controller 
	 */
	public MainWindow(ArrayList<String> data, MainController controller) {
		this.controller = controller;
		initialize();
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
