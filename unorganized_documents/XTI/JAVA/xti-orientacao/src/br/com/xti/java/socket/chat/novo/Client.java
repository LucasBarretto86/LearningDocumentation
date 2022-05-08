package br.com.xti.java.socket.chat.novo;

import javax.swing.JOptionPane;

public class Client{
	private ClientConnectionFactory clientConnection;
	private String clientName;
	private String clientStatus;
	
	public Client(String name) {
		try {
			clientConnection = new ClientConnectionFactory();
			if(clientConnection.isConnected()) {
				this.clientStatus = "Online";
			} else {
				this.clientStatus = "Offline";
			}
			this.clientName = name;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Problema ao estabelecer conexão com o Servidor!");
			e.printStackTrace();
		}	
	}

	public ClientConnectionFactory getConnection() {
		return this.clientConnection;
	}
	
	public void setClientStatus(String clientStatus) {
		this.clientStatus = clientStatus;
	}

	public String getClientStatus() {
		return clientStatus;
	}
	
	public String getName() {
		return clientName;
	}

	public boolean isOnline() {

		if(this.clientStatus.equals("Online")) {
			return true;
		}
		return false;
	}
	



}
