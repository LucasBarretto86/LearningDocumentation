package br.com.xti.java.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ControleTextArea extends JFrame implements ActionListener {

	JTextArea texto;

	public ControleTextArea() {

		super("Editor de textos");

		texto = new JTextArea();
		JScrollPane scroll = new JScrollPane(texto);
		texto.setFont(new Font("Calibri", Font.PLAIN, 15));

		JButton button = new JButton("Abrir Arquivo");
		button.setFont(new Font("Calibri", Font.PLAIN, 15));
		button.addActionListener(this);

		Container c = getContentPane();
		c.add(BorderLayout.CENTER, scroll);
		c.add(BorderLayout.SOUTH, button);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(this);
		File file = chooser.getSelectedFile();

		try {
			Path path = Paths.get(file.getAbsolutePath());
			String retorno = new String(Files.readAllBytes(path));
			texto.setText(retorno);

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Erro:" + erro);
		}
	}

	public static void main(String[] args) {
		new ControleTextArea();
	}

}
