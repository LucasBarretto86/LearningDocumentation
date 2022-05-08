package br.com.xti.java.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ControleLabel extends JFrame {

	public ControleLabel() {

		super("Label");

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel label = new JLabel("Label"); // Cria Label, estabelece texto no construtor
		label.setToolTipText("Esse é o label criado"); // Seta o texto que aparece ao deixar mouse sobre o label
		c.add(label); // add o label ao container

		JLabel label2 = new JLabel("new label");
		Font font = new Font("serif", Font.ITALIC, 28);
		label2.setFont(font); // usa parametros da classe de fontes para setar nos itens desejados e seta a
								// label com o padrao
		label2.setForeground(Color.BLUE); // Altera a cor do label
		c.add(label2);

		ImageIcon icon = new ImageIcon(getClass().getResource("image/Emulandomark.png"));
		JLabel imagem = new JLabel(icon);
		c.add(imagem);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);

	}

	public static void main(String[] args) {
		new ControleLabel();

	}

}
