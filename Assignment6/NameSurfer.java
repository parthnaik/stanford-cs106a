/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import acm.util.*;

public class NameSurfer extends Program implements NameSurferConstants {

	/* Private instance variables*/ 
	private JTextField name;
	private JButton displayGraph;
	private JButton clear;
	private NameSurferDataBase nameSurferDB;
	private NameSurferGraph graph;
	
	/* Method: init() */
	/**
	 * This method has the responsibility for reading in the data base
	 * and initializing the interactors at the bottom of the window.
	 */
	public void init() {
		// You fill this in, along with any helper methods //
		JLabel label = new JLabel("Name: ");
		add(label, NORTH);
		
		name = new JTextField(20);
		add(name, NORTH);
		name.addActionListener(this);
		
		displayGraph = new JButton("Graph");
		add(displayGraph, NORTH);
		
		clear = new JButton("Clear");
		add(clear, NORTH);
		
		graph = new NameSurferGraph();
		add(graph);
		
		addActionListeners();
		
		//reads the file of names and adds to the NameSurferDataBase
		nameSurferDB = new NameSurferDataBase(NAMES_DATA_FILE);
	}
	
	/* Method: actionPerformed(e) */
	/**
	 * This class is responsible for detecting when the buttons are
	 * clicked, so you will have to define a method to respond to
	 * button actions.
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clear) {
			graph.clear();
			graph.update();
		}
		else {
			String query = name.getText();
			NameSurferEntry entry = nameSurferDB.findEntry(query);
			
			if (entry != null) {
				graph.addEntry(entry);
				graph.update();
			}
			
			name.setText("");
		}
	}
}