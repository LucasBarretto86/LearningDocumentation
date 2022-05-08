package br.com.xti.java.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ControleCheck extends JFrame {

	JTextField text;
	JCheckBox bold;
	JCheckBox italic;

	public ControleCheck() {
		super("Controle Check");

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		text = new JTextField("Veja a Fonte Mudar", 12);
		text.setFont(new Font("Serif", Font.PLAIN, 26));

		bold = new JCheckBox("Bold", false);
		bold.addItemListener(new CheckBoxListener());

		italic = new JCheckBox("Italic", false);
		italic.addItemListener(new CheckBoxListener());

		c.add(text);
		c.add(bold);
		c.add(italic);

		setSize(300, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		new ControleCheck();

	}

	public class CheckBoxListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {

			if (bold.isSelected() && italic.isSelected()) {
				text.setFont(new Font("Serif", Font.ITALIC | Font.BOLD, 26));

			} else if (bold.isSelected()) {
				text.setFont(new Font("Serif", Font.BOLD, 26));

			} else if (italic.isSelected()) {
				text.setFont(new Font("Serif", Font.ITALIC, 26));

			} else {
				text.setFont(new Font("Serif", Font.PLAIN, 26));
			}
		}
	}
}