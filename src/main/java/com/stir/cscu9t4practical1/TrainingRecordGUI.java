// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

 public class TrainingRecordGUI extends JFrame implements ActionListener {

	private JTextField name = new JTextField(30);
	private JTextField day = new JTextField(2);
	private JTextField month = new JTextField(2);
	private JTextField year = new JTextField(4);
	private JTextField hours = new JTextField(2);
	private JTextField mins = new JTextField(2);
	private JTextField secs = new JTextField(2);
	private JTextField dist = new JTextField(4);
	private JTextField rep = new JTextField(10);
	private JTextField rec = new JTextField(10);
	private JTextField tempo = new JTextField(10);
	private JTextField ter = new JTextField(10);
	private JTextField whr = new JTextField(10);
	private JLabel labn = new JLabel(" Name:");
	private JLabel labd = new JLabel(" Day:");
	private JLabel labm = new JLabel(" Month:");
	private JLabel laby = new JLabel(" Year:");
	private JLabel labh = new JLabel(" Hours:");
	private JLabel labmm = new JLabel(" Mins:");
	private JLabel labs = new JLabel(" Secs:");
	private JLabel labdist = new JLabel(" Distance (km):");
	private JLabel labr = new JLabel(" repetition:");
	private JLabel labr1 = new JLabel(" recovery:");
	private JLabel labt = new JLabel(" tempo:");
	private JLabel labt1 = new JLabel(" terrain:");
	private JLabel labw = new JLabel(" where:");
	private JButton addR = new JButton("Add");
	private JButton lookUpByDate = new JButton("Look Up");
	private TrainingRecord myAthletes = new TrainingRecord();
	private JButton FindAllByDate = new JButton("Look Up all");
	private JButton removeAll = new JButton("Remove the record");
	private JRadioButton radd = new JRadioButton("swimming");
	private JRadioButton radd2 = new JRadioButton("running");
	private JRadioButton radd3 = new JRadioButton("cycling");

	private JTextArea outputArea = new JTextArea(5, 50);

	public static void main(String[] args) {
		TrainingRecordGUI applic = new TrainingRecordGUI();
	} // main

	// set up the GUI
	public TrainingRecordGUI() {
		super("Training Record");
		setLayout(new FlowLayout());
		add(labn);
		add(name);
		name.setEditable(true);
		add(labd);
		add(day);
		day.setEditable(true);
		add(labm);
		add(month);
		month.setEditable(true);
		add(laby);
		add(year);
		year.setEditable(true);
		add(labh);
		add(hours);
		hours.setEditable(true);
		add(labmm);
		add(mins);
		mins.setEditable(true);
		add(labs);
		add(secs);
		secs.setEditable(true);
		add(labdist);
		add(dist);
		dist.setEditable(true);
		add(labr);
		add(rep);
		rep.setEditable(true);
		add(labr1);
		add(rec);
		rec.setEditable(true);
		add(labt);
		add(tempo);
		tempo.setEditable(true);
		add(labt1);
		add(ter);
		ter.setEditable(true);
		add(labw);
		add(whr);
		whr.setEditable(true);
		add(addR);
		addR.addActionListener(this);
		ButtonGroup group = new ButtonGroup();
		radd.setBounds(140, 140, 40, 40);
		group.add(radd);
		add(radd);
		radd.addActionListener(e -> {
			System.out.println("man: " + ((JRadioButton) e.getSource()).isSelected());
		});

		radd2.setBounds(140, 140, 40, 40);
		group.add(radd2);
		add(radd2);
		radd2.addActionListener(e -> {
			System.out.println("kug: " + ((JRadioButton) e.getSource()).isSelected());
		});

		radd3.setBounds(140, 140, 40, 40);
		group.add(radd3);
		add(radd3);
		radd3.addActionListener(e -> {
			System.out.println("pih: " + ((JRadioButton) e.getSource()).isSelected());
		});
		
		add(removeAll);
		removeAll.addActionListener(this);
		
		add(lookUpByDate);
		lookUpByDate.addActionListener(this);
		add(FindAllByDate);
		FindAllByDate.addActionListener(this);
		add(outputArea);
		outputArea.setEditable(false);
		setSize(720, 200);
		setVisible(true);
		blankDisplay();

		// To save typing in new entries while testing, uncomment
		// the following lines (or add your own test cases)

	} // constructor

	// listen for and respond to GUI events
	public void actionPerformed(ActionEvent event) {
		String message = "";
		if (event.getSource() == addR) {
			message = addEntry("generic");
		}
		if (event.getSource() == lookUpByDate) {
			message = lookupEntry();
		}

		if (event.getSource() == FindAllByDate) {
			message = FindAllByDate();
		}
		if(event.getSource() == removeAll ) {
			removeAll();
			}
		outputArea.setText(message);
		blankDisplay();

	} // actionPerformed

	public String addEntry(String what) {
		String message = "Record added\n";
		System.out.println("Adding " + what + " entry to the records");
		String n = name.getText();
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		float km = java.lang.Float.parseFloat(dist.getText());
		int h = Integer.parseInt(hours.getText());
		int mm = Integer.parseInt(mins.getText());
		int s = Integer.parseInt(secs.getText());
		int repetitions = Integer.parseInt(rep.getText());
		int recovery = Integer.parseInt(rec.getText());
		String tem = tempo.getText();
		String terrain = ter.getText();
		String where = whr.getText();
		
		if(radd.isSelected() == true){
			Entry e = new SwimEntry(n, d, m, y, h, mm, s, km,where);
			myAthletes.addEntry(e);
			return message;
			}
			else if(radd2.isSelected() == true){
			Entry e = new SprintEntry(n, d, m, y, h, mm, s, km,repetitions,recovery);
			myAthletes.addEntry(e);
			return message;
			}
			else if(radd3.isSelected() == true){
			Entry e = new CycleEntry(n, d, m, y, h, mm, s, km,terrain,tem);
			myAthletes.addEntry(e);
			return message;
			}
			else {
		Entry e = new Entry(n, d, m, y, h, mm, s, km);

		myAthletes.addEntry(e);
		return message;
	}
	}

	public String lookupEntry() {
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText("looking up record ...");
		String message = myAthletes.lookupEntry(d, m, y);
		return message;
	}

	public String FindAllByDate() {
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText("looking up record ...");
		String message = myAthletes.FindAllByDate(d, m, y);
		return message;
	}
	public void removeAllEntry() {
		String n = name.getText();
		int m = Integer.parseInt(month.getText());
		int d = Integer.parseInt(day.getText());
		int y = Integer.parseInt(year.getText());
		outputArea.setText("looking up record ...");
		myAthletes.removeEntry(n,d, m, y);



		}
	public void blankDisplay() {
		name.setText("");
		day.setText("");
		month.setText("");
		year.setText("");
		hours.setText("");
		mins.setText("");
		secs.setText("");
		dist.setText("");
		rep.setText("");
		rec.setText("");
		tempo.setText("");
		ter.setText("");
		whr.setText("");

	}// blankDisplay
		// Fills the input fields on the display for testing purposes only

	public void fillDisplay(Entry ent) {
		name.setText(ent.getName());
		day.setText(String.valueOf(ent.getDay()));
		month.setText(String.valueOf(ent.getMonth()));
		year.setText(String.valueOf(ent.getYear()));
		hours.setText(String.valueOf(ent.getHour()));
		mins.setText(String.valueOf(ent.getMin()));
		secs.setText(String.valueOf(ent.getSec()));
		dist.setText(String.valueOf(ent.getDistance()));
		
	}

} // TrainingRecordGUI
