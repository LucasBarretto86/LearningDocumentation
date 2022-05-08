package br.com.xti.java.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Layouts2 extends JFrame {

	public Layouts2() {
		super("Layout2");
		Container c = getContentPane();

		// Create a second Container setting lines, columns and add buttons
		Container c2 = new JPanel();
		c2.setLayout(new GridLayout(4, 1));
		c2.add(new JButton("1"));
		c2.add(new JButton("2"));
		c2.add(new JButton("3"));
		c2.add(new JButton("4"));

		c.setLayout(new BorderLayout());
		c.add(new JButton("Center"));
		c.add(BorderLayout.EAST, c2);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 300);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Layouts2();
	}

}
