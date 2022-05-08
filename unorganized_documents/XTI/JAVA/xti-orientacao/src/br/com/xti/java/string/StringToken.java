package br.com.xti.java.string;

public class StringToken {

	public static void main(String[] args) {

		// TOKENIZAÇÃO

		String string = "Java, CSS, HTML, jQuery";
		String[] tokens = string.split(", ");

		for (String token : tokens) {
			System.out.println(token);

		}

		// Especifica um delimitador, para efetuar a quebra de um String gerando Um
		// array com cada token,
		// neste caso usando o metodo .split(", "), estamos especificando o o nosso
		// token como o ", " que
		// retorna um array com a as palavras. For somente usando para exbir o array
		// gerado.

	}

}
