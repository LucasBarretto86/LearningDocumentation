package br.com.xti.java.socket.chat.novo;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ChatServer {
	private static List<Client> clients = new ArrayList<>();
	private List<PrintWriter> clientsMsgs = new ArrayList<>();
	private boolean serverConnected;

	public ChatServer() {
		ServerSocket server;

		try {
			server = new ServerSocket(5005);
			this.serverConnected = true;
			System.out.println("Server Online!");

			while (true) {
				Socket serverSocket = server.accept();
				new Thread(new ClientListener(serverSocket)).start();
				PrintWriter output = new PrintWriter(serverSocket.getOutputStream());
				clientsMsgs.add(output);
			}
		} catch (Exception e) {
			this.serverConnected = false;
			System.out.println("Server Offline!");
			e.printStackTrace();
		}
	}

	public static List<Client> getClients() {
		return clients;
	}

	public boolean isConnected() {
		if (serverConnected) {
			return true;
		}
		return false;
	}

	public void shareToAll(String text) {

		for (PrintWriter chatMsg : clientsMsgs) {
			try {
				chatMsg.println(text);
				chatMsg.flush();

			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao direcionar mensagens aos clientes!");
			}
		}
	}

	private class ClientListener implements Runnable {
		Scanner serverInput;

		public ClientListener(Socket socket) {
			try {
				serverInput = new Scanner(socket.getInputStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {

			try {
				String clientText;
				while ((clientText = serverInput.nextLine()) != null) {
					shareToAll(clientText);
					System.out.println(clientText);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		new ChatServer();
	}

}
