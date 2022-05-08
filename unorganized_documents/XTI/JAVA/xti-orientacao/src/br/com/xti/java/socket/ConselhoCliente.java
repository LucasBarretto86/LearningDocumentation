package br.com.xti.java.socket;

import java.net.Socket;
import java.util.Scanner;

public class ConselhoCliente {

	public static void main(String[] args) throws Exception {
		
		Socket socket = new Socket("127.0.1.10", 8005);
		
		Scanner input = new Scanner(socket.getInputStream());
		System.out.println("Mensagem " + input.nextLine());
		
		input.close();
	}

}
