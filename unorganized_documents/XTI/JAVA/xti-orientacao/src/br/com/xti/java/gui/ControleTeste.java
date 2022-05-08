package br.com.xti.java.gui;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ControleTeste extends JFrame {

	String login = "lbarretto";
	String senha = "123456";
	JButton ok;
	JButton cancela;
	JTextField loginInput;
	JPasswordField senhaInput;

	public ControleTeste() {

		super("Textos e Senhas");

		this.ok = new JButton("OK");
		this.ok.addActionListener(new botaoOkListener());

		this.cancela = new JButton("Cancel");
		this.cancela.addActionListener(new botaoCancelaListener());

		this.loginInput = new JTextField();
		this.senhaInput = new JPasswordField();

		Container c = getContentPane();
		c.setLayout(new GridLayout(3, 2));
		c.add(new JLabel("Login:"));
		c.add(this.loginInput);
		c.add(new JLabel("Senha:"));
		c.add(this.senhaInput);
		c.add(this.ok);
		c.add(this.cancela);

		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public class botaoOkListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane mensagem = new JOptionPane();
			if ((login.equals(loginInput.getText()))
					&& (senha.equals(String.copyValueOf((senhaInput.getPassword()))))) {
				mensagem.showMessageDialog(null, "Você foi logado");
			} else {
				System.out.println("Dados Errados");
			}
		}

	}

	public class botaoCancelaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			loginInput.setText("");
			senhaInput.setText("");
			System.out.println("Login Cancelado");

		}
	}

	public static void main(String[] args) {
		new ControleTeste();
	}

}
