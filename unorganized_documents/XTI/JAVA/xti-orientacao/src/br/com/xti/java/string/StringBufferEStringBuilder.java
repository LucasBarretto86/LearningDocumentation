package br.com.xti.java.string;

public class StringBufferEStringBuilder {

	public static void main(String[] args) {

		/* STRINGBUILDER FILHA DA CLASSE STRING */

		StringBuilder s1 = new StringBuilder("Java");
		// Ambas exigem a cria��o do objeto, podendo ou n�o conter um parametro.

		s1.length();
		System.out.println(s1.length());
		// Informa o lenght de char.

		s1.capacity();
		System.out.println(s1.capacity());
		// Informa a capacidade inicial para inclus�o de novos chars com uso do metodo
		// append().

		s1.toString();
		System.out.println(s1.toString());
		// Exibe o valor da vari�vel em String.

		s1.reverse();
		System.out.println(s1);
		// Inverte a ordem dos chars de uma String.

		s1.replace(0, 4, "Trabalhando ");
		System.out.println(s1);
		// Replace usando referencia da ordem index de chars, mensagem anterior era
		// "avaJ" sendo que o index 0
		// era 'a' e 4 � 'J', portanto replace.(index inicial, index final, nova
		// String).

		s1.append("com ");
		System.out.println(s1);
		// Acrescenta novas Strings � String j� criada.

		char[] t = { 't', 'e', 'x', 't', 'o' };
		s1.append(t);
		System.out.println(s1);
		// O metodo append tamb�m aceita acrescentar novas Strings via array.

		s1.append(" nas aulas").append("da XTI.");
		System.out.println(s1);
		// Append tamb�m permite multiplas utiliza��es do metodo em apenas uma linha,
		// pois tem retorno this.

		/* STRINGBUFFER FILHA DA CLASSE STRING */

		StringBuffer s0 = new StringBuffer();

		System.out.println(s0.append("Java"));
		System.out.println(s0.length());
		System.out.println(s0.capacity());
		System.out.println(s0.toString());
		// A Classe StringBuffer tamb�m possui metodos iguais � classe StringBuilder com
		// difenre�a apenas no
		// modo de armazenar as informa��es no quesito de mem�ria.

		/*
		 * MAIS SOBRE A CLASSE STRING E COMO ELA USA EM SUA ESTRUTURA AS CLASSES
		 * STRINGBUILDER
		 */

		String s = "Java " + "trabalhando " + "com " + "Textos";
		String sb = new StringBuilder("Java ").append("trabalhando ").append("com ").append("Textos").toString();
		// Quando fazemos um concatena��o de um obj String a JVM usa o StringBuilder.

		System.out.println(s);
		System.out.println(sb);

		// Por�m toda vez que fazemos uma nova concatena��o via String a JVM cria um
		// novo objeto equando se
		// usarmos o append via StringBuilder apenas acrescentariamos, tortando a
		// aplica��o mais rapida.

	}

}
