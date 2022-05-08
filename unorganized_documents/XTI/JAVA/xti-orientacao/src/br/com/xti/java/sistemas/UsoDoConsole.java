package br.com.xti.java.sistemas;

import java.io.Console;

public class UsoDoConsole {

	public static void main(String[] args) {

		/*Uma forma de uso da ferramenta console, de forma mais segura para tratar a coleta de dados do prompt de comando
		 * somente funciona em aplicações que sejam executadas no prompt de comando*/
		
		Console c = System.console();
		System.out.println( "Usuário: " );
		String user = c.readLine();  // Funciona da mesma forma que o Scanner, porém, somente no prompt
		System.out.println("Senha: ");
		char[] pass = c.readPassword(); // Tratamento para leitura de senha de modo seguro dentro do prompt
		
		System.out.println("Usuário: " + user + " Senha: " + new String(pass));
	}

}
