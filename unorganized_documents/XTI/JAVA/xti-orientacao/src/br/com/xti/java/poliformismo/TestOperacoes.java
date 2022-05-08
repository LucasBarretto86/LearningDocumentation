package br.com.xti.java.poliformismo;

public class TestOperacoes {

	public static void main(String[] args) {

		OperacaoMatematica.calcule(new Soma(), 5, 5);
		OperacaoMatematica.calcule(new Multiplicacao(), 5, 5);

		OperacaoMatematica.calculeSemPoliformismo("Soma", 5, 5);
		OperacaoMatematica.calculeSemPoliformismo("Multiplicacao", 5, 5);

	}

}
