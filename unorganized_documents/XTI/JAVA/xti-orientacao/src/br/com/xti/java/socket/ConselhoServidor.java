package br.com.xti.java.socket;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ConselhoServidor {

	public static void main(String[] args) throws Exception {
		
		ServerSocket server = new ServerSocket(8005);
		
		while(true) {
			Socket socket = server.accept();
			
			try(PrintWriter pw = new PrintWriter(socket.getOutputStream())){
				pw.println("Aprenda Java e seja Feliz!");
			} 
		}
	}

}
