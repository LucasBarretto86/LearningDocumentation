package br.com.xti.desafio.editordetexto.model;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EditorText extends JFrame {

	static JTextArea text = new JTextArea();

	public EditorText() {
		super("Editor de Texto");

		JScrollPane scroll = new JScrollPane(text);

		NewFileButton newfile = new NewFileButton("New File");
		LoadButton load = new LoadButton("Load File");
		SaveButton save = new SaveButton("Save File");

		newfile.addActionListener(newfile);
		load.addActionListener(load);
		save.addActionListener(save);

		Container c = getContentPane();
		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(1, 2));

		panel.add(newfile, 1, 0);
		panel.add(load, 1, 1);
		panel.add(save, 1, 2);

		c.add(BorderLayout.NORTH, panel);
		c.add(BorderLayout.CENTER, scroll);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);

	}
}
