package br.com.xti.java.socket.chat.novo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ClientConnectionFactory extends Socket{

	private Socket clientSocket = null;
	private boolean clientConnected = false;
	
	public ClientConnectionFactory() {
		getClientSocket();
	}

	public Socket getClientSocket() {
		try {
			clientSocket = new Socket("127.0.0.22", 5005);
			JOptionPane.showMessageDialog(null,"Conectado com Sucesso");
			this.clientConnected = true;
			
		} catch (IOException e) {
			e.printStackTrace();
			this.clientConnected = false;
			JOptionPane.showMessageDialog(null,"A Conexão Falhou");
		}
		return clientSocket;
	}
	
	public boolean isConnected() {
		if(clientConnected) {
			return true;
		}
		return false;
	}

	public Scanner getClientInput() {
		Scanner clientInput = null;
		try {
			clientInput = new Scanner(clientSocket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return clientInput;
	}
	
	public PrintWriter getClientOutput(){
		PrintWriter clientOutput = null;
		try {
			clientOutput = new PrintWriter(clientSocket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return clientOutput;
	}
	
}
