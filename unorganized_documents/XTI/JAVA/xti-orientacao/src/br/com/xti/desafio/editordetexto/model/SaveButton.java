package br.com.xti.desafio.editordetexto.model;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SaveButton extends JButton implements ActionListener {

	public SaveButton(String buttonTitle) {
		super(buttonTitle);
		setFont(new Font("Calibri", Font.PLAIN, 15));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser c = new JFileChooser();
		c.showSaveDialog(this);
		PrintStream ps = null;
		try {
			Path path = Paths.get(c.getSelectedFile().getPath() + ".txt");
			ps = new PrintStream(path.toString());

			ps.println(EditorText.text.getText());
			JOptionPane.showMessageDialog(this, "File Saved");

		} catch (Exception error) {
			JOptionPane pane = new JOptionPane();
			pane.showMessageDialog(this, "Não foi possivel salvar arquivo neste local!");
		}

	}

}
