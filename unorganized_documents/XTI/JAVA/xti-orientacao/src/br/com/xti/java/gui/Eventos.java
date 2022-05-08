package br.com.xti.java.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Eventos extends JFrame implements ActionListener {

	JButton b1;

	public Eventos() {
		super("Eventos");

		b1 = new JButton("Clique Aqui");
		Container c = getContentPane();
		c.add(b1);

		b1.addActionListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JOptionPane pane = new JOptionPane("Botão Clicado");
		pane.showMessageDialog(null, "Você clicou o botão, lindinho!");
		b1.setText("Clicado");

	}

	public static void main(String[] args) {
		new Eventos();
	}

}
