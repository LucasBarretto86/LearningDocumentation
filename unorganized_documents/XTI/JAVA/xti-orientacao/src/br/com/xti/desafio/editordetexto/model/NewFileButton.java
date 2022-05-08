package br.com.xti.desafio.editordetexto.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NewFileButton extends JButton implements ActionListener {

	public NewFileButton(String buttonTitle) {
		super(buttonTitle);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		EditorText.text.setText("");

	}

}
