package br.com.xti.java.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame {

	public Janela() {

		super("Minha Janela");
		JButton button = new JButton("Clique Aqui");
		getContentPane().add(button);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);

	}

	public static void main(String[] args) {

		new Janela();
	}

}
