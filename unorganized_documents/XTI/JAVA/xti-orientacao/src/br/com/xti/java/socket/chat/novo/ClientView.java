package br.com.xti.java.socket.chat.novo;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DropMode;

public class ClientView extends JFrame {

	private Client client;
	private JTextArea txtArea_Input;
	private JTextArea txtArea_Output;
	private JTextArea txtArea_ClientsOnline;
	private Thread trServerMsgs;
	private Thread trServerClients;

	public ClientView(Client client) {
		this.client = client;
		ChatServer.getClients().add(client);

		setType(Type.UTILITY);
		setTitle("JumpJackChat - " + client.getName() + " - " + client.getClientStatus());

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 475, 200 };
		gridBagLayout.rowHeights = new int[] { 300 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0 };
		getContentPane().setLayout(gridBagLayout);

		txtArea_Input = new JTextArea();
		txtArea_Input.setWrapStyleWord(true);
		txtArea_Input.setDropMode(DropMode.INSERT);
		txtArea_Input.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtArea_Input.setTabSize(4);
		txtArea_Input.setLineWrap(true);
		txtArea_Input.setEnabled(false);
		txtArea_Input.setEditable(false);
		trServerMsgs = new Thread(new ServerListener());
		trServerMsgs.start();

		GridBagConstraints gbc_txtArea_Input = new GridBagConstraints();
		gbc_txtArea_Input.insets = new Insets(5, 5, 5, 0);
		gbc_txtArea_Input.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtArea_Input.fill = GridBagConstraints.BOTH;
		gbc_txtArea_Input.gridx = 0;
		gbc_txtArea_Input.gridy = 0;
		JScrollPane scroll_txtArea_Input = new JScrollPane(txtArea_Input);
		getContentPane().add(scroll_txtArea_Input, gbc_txtArea_Input);

		txtArea_ClientsOnline = new JTextArea();
		txtArea_ClientsOnline.setDropMode(DropMode.INSERT);
		txtArea_ClientsOnline.setLineWrap(true);
		txtArea_ClientsOnline.setWrapStyleWord(true);
		txtArea_ClientsOnline.setEnabled(false);
		txtArea_ClientsOnline.setEditable(false);
		txtArea_ClientsOnline.setFont(new Font("Calibri", Font.PLAIN, 20));
		trServerClients = new Thread(new ServerListener());
		trServerClients.start();

		GridBagConstraints gbc_txtAreaClientsOnline = new GridBagConstraints();
		gbc_txtAreaClientsOnline.insets = new Insets(5, 5, 5, 5);
		gbc_txtAreaClientsOnline.fill = GridBagConstraints.BOTH;
		gbc_txtAreaClientsOnline.gridx = 1;
		gbc_txtAreaClientsOnline.gridy = 0;
		JScrollPane scroll_txtArea_ClientsOnline = new JScrollPane(txtArea_ClientsOnline);
		getContentPane().add(scroll_txtArea_ClientsOnline, gbc_txtAreaClientsOnline);

		txtArea_Output = new JTextArea();
		txtArea_Output.setDropMode(DropMode.INSERT);
		txtArea_Output.setFont(new Font("Calibri", Font.PLAIN, 20));
		txtArea_Output.setLineWrap(true);
		txtArea_Output.setWrapStyleWord(true);
		GridBagConstraints gbc_txtArea_Output = new GridBagConstraints();
		gbc_txtArea_Output.insets = new Insets(0, 5, 5, 0);
		gbc_txtArea_Output.fill = GridBagConstraints.BOTH;
		gbc_txtArea_Output.gridx = 0;
		gbc_txtArea_Output.gridy = 1;
		JScrollPane scroll_txtArea_Output = new JScrollPane(txtArea_Output);
		getContentPane().add(scroll_txtArea_Output, gbc_txtArea_Output);
		JButton btn_Send = new JButton("Enviar");
		btn_Send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PrintWriter clientOut = client.getConnection().getClientOutput();
				clientOut.println(client.getName() + ": " + txtArea_Output.getText());
				clientOut.flush();
				txtArea_Output.setText("");
				txtArea_Output.requestFocus();
			}
		});

		btn_Send.setFont(new Font("Calibri", Font.PLAIN, 20));
		GridBagConstraints gbc_btn_Send = new GridBagConstraints();
		gbc_btn_Send.insets = new Insets(0, 5, 5, 5);
		gbc_btn_Send.gridx = 1;
		gbc_btn_Send.gridy = 1;
		getContentPane().add(btn_Send, gbc_btn_Send);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private class ServerListener implements Runnable {

		@Override
		public void run() {
			if (Thread.currentThread() == trServerMsgs) {
				Scanner clientIn = client.getConnection().getClientInput();
				try {
					String texto;
					while ((texto = clientIn.nextLine()) != null) {
						txtArea_Input.append(texto + "\n");
					}
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao exibir mensagem do Usuário!");
				}
			} else if (Thread.currentThread() == trServerClients) {
				txtArea_ClientsOnline.setText("");
				try {
					for (Client client : ChatServer.getClients()) {
						txtArea_ClientsOnline.append(client.getName() + "\n");
					}
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao exibir nome do Usuário!");
				}
			}
		}
	}
}
