package br.com.xti.java.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ControleCombo extends JFrame implements ItemListener {

	JComboBox<String> combo;
	JLabel imagem;
	ImageIcon[] imagens = { new ImageIcon(getClass().getResource("image/1.png")),
			new ImageIcon(getClass().getResource("image/2.png")), new ImageIcon(getClass().getResource("image/3.png")),
			new ImageIcon(getClass().getResource("image/4.png")), };

	public ControleCombo() {
		super("Controle ComboBox");

		Container c = getContentPane();

		combo = new JComboBox<>();
		combo.setFont(new Font("Calibri", Font.PLAIN, 12));
		combo.addItem("Son Goku");
		combo.addItem("XiaoJiao");
		combo.addItem("Lucas");
		combo.addItem("Kermit");
		combo.addItemListener(this);
		imagem = new JLabel(imagens[0]);

		c.add(BorderLayout.NORTH, combo);
		c.add(BorderLayout.CENTER, imagem);

		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			imagem.setIcon(imagens[combo.getSelectedIndex()]);
		}
	}

	public static void main(String[] args) {
		new ControleCombo();

	}
}