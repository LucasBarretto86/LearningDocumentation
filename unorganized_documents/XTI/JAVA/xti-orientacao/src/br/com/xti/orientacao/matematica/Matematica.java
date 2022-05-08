package br.com.xti.orientacao.matematica;

public class Matematica {

	public float soma(float... valores) {
		float total = 0;
		for (float i : valores) {
			total += i;
		}

		return total;
	}

	public int maior(int valor1, int valor2) {
		if (valor1 > valor2) {
			return valor1;
		} else {
			return valor2;
		}
	}

	public int raiz(int valor) {
		int raiz = 1;

		for (int i = 1; i < valor; i++) {

			if (i % 2 == 1) {
				valor -= i;
				raiz++;
			}
		}

		return raiz;

	}

	public float media(float... numeros) {
		float total = 0;
		for (int i = 0; i < numeros.length; i++) {
			total += numeros[i];
		}
		return total / numeros.length;
	}
	
	public int divide (int dividendo, int divisor) {
		return dividendo / divisor;
	}
}