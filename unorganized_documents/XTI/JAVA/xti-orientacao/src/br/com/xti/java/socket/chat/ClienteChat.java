package br.com.xti.java.socket.chat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClienteChat extends JFrame {

	JTextField textoOutput;
	JTextArea chatArea;
	JTextArea clientsListArea;
	Socket socket;
	PrintWriter output;
	Scanner input;
	
	public ClienteChat(String name) {

		super("JumpJackChat - " + name);

		Container userPanel = new JPanel();
		userPanel.setLayout(new BorderLayout(5, 10));
		textoOutput = new JTextField();

		JButton bEnviar = new JButton("Enviar");
		bEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				output.println(name + ": " + textoOutput.getText());
				output.flush();
				textoOutput.setText("");
				textoOutput.requestFocus();
			}
		});
		
		userPanel.add(BorderLayout.CENTER, textoOutput);
		userPanel.add(BorderLayout.EAST, bEnviar);

		Container chatPanel = new JPanel();
		chatPanel.setLayout(new BorderLayout(5, 5));
		chatArea = new JTextArea();
		JScrollPane chatScroll = new JScrollPane(chatArea);
		chatPanel.add(BorderLayout.CENTER, chatScroll);

		Container clientsListPanel = new JPanel();
		clientsListPanel.setLayout(new BorderLayout(5, 5));
		clientsListArea = new JTextArea();
		
		JScrollPane clientsListScroll = new JScrollPane(clientsListArea);
		clientsListPanel.add(BorderLayout.CENTER, clientsListScroll);

		Container main = getContentPane();
		main.setLayout(new BorderLayout(5, 10));
		main.add(BorderLayout.SOUTH, userPanel);
		main.add(BorderLayout.CENTER, chatPanel);
		main.add(BorderLayout.EAST, clientsListPanel);

		getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 200);
		setVisible(true);
	}

	private class ServerListener implements Runnable {
		
		@Override
		public void run() {
			try {
				String texto;
				while ((texto = input.nextLine()) != null) {
					chatArea.append(texto + "\n");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void getConnection() {
		try {
			socket = new Socket("127.0.0.22", 5005);
			input = new Scanner(socket.getInputStream());
			output = new PrintWriter(socket.getOutputStream());
			new Thread().start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ClienteChat("Lucas");
		new ClienteChat("XiaoJiao");
	}
}
