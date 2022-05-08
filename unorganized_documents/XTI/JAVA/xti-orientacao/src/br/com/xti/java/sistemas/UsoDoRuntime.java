package br.com.xti.java.sistemas;

import java.io.IOException;

public class UsoDoRuntime {

	public static void main(String[] args) throws IOException {
		
		/*Runtime controla o uso do OS do usuario para eventualmente chamar aplicações externas*/
		
		Runtime.getRuntime().exec("calc"); // invoca o comando que chama a calculadora
	}

}
