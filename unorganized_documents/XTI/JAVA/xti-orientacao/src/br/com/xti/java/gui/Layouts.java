package br.com.xti.java.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Layouts extends JFrame {

	public Layouts() {
		super("Layouts");

		Container c = getContentPane();

		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");

		/*
		 * BORDER LAYOUT - DEFAULT c.setLayout(new BorderLayout(40, 60)); //Setting
		 * Layout and spaces between components c.add(BorderLayout.NORTH, b1);
		 * c.add(BorderLayout.WEST, b2); c.add(BorderLayout.CENTER, b3);
		 * c.add(BorderLayout.EAST, b4); c.add(BorderLayout.SOUTH, b5);
		 */

		/*
		 * FLOW LAYOUT - Must be set setLayout(new FlowLayout()); c.add(b1); c.add(b2);
		 * c.add(b3); c.add(b4); c.add(b5);
		 */

		/* GRID LAYOUT - Must be set */
		int lines = 2;
		int columns = 3;

		setLayout(new GridLayout(lines, columns));

		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(b4);
		c.add(b5);
		c.add(b6);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Layouts();
	}
}
