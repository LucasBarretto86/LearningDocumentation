package br.com.xti.java.poliformismo;

public class OperacaoMatematica {

	public static void calcule(OperacaoMatematica operacao, double x, double y) {

	}

	public static void calculeSemPoliformismo(String operacao, double x, double y) {

		if (operacao.equals("Soma")) {
			System.out.println(x + y);

		} else {
			System.out.println(x * y);
		}
	}

}
