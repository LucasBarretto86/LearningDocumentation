package br.com.xti.desafio.editordetexto.model;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class LoadButton extends JButton implements ActionListener {

	public LoadButton(String buttonTitle) {
		super(buttonTitle);
		setFont(new Font("Calibri", Font.PLAIN, 15));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser c = new JFileChooser();
		c.showOpenDialog(this);
		File file = c.getSelectedFile();
		try {
			Path path = Paths.get(file.getAbsolutePath());
			String retorno = new String(Files.readAllBytes(path));
			EditorText.text.setText(retorno);
			JOptionPane.showMessageDialog(this, "File Loaded");

		} catch (Exception error) {
			JOptionPane pane = new JOptionPane();
			pane.showMessageDialog(this, "Não foi possível carregar o arquivo");
		}

	}

}
