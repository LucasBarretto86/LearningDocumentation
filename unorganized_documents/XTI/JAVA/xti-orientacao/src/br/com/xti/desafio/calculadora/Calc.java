package br.com.xti.desafio.calculadora;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calc extends JFrame {
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bPeriod, bEqual, bDivision, bMultiply, bMinus, bPlus;

	public Calc() {
		super("Calculadora");

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		Container panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));

		JTextField display = new JTextField();
		container.add(BorderLayout.NORTH, display);
		display.setFont(new Font("Serif", Font.PLAIN, 26));
		container.add(BorderLayout.CENTER, panel);
		setButtons(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	private Container setButtons(Container panel) {

		panel.add(b7 = new JButton("7"));
		panel.add(b8 = new JButton("8"));
		panel.add(b9 = new JButton("9"));
		panel.add(bDivision = new JButton("/"));
		panel.add(b4 = new JButton("4"));
		panel.add(b5 = new JButton("5"));
		panel.add(b6 = new JButton("6"));
		panel.add(bMultiply = new JButton("*"));
		panel.add(b1 = new JButton("1"));
		panel.add(b2 = new JButton("2"));
		panel.add(b3 = new JButton("3"));
		panel.add(bMinus = new JButton("-"));
		panel.add(b0 = new JButton("0"));
		panel.add(bPeriod = new JButton("."));
		panel.add(bEqual = new JButton("="));
		panel.add(bPlus = new JButton("+"));
		return panel;
	}

}
