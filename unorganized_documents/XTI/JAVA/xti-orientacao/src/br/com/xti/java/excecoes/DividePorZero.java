package br.com.xti.java.excecoes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DividePorZero {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean continua = true;

		do {

			try {
				System.out.println("Informe um numero: ");
				int primeiroNumero = input.nextInt();

				System.out.println("Informe um divisor: ");
				int divisor = input.nextInt();

				System.out.println("Resultado: " + primeiroNumero / divisor);
				continua = false;

			} catch (ArithmeticException a) {
				System.err.println("Erro Capturado, numero não pode ser zero");
				// System.err printa um texto com em relevo, usado para erros.

				input.nextLine();
				// Apenas para descartar e entrada errada e abrir o scanner para insersão de
				// novos dados.

			} catch (InputMismatchException i) {
				System.err.println("Erro Capturado, informe apenas números");
				input.nextLine();

			} finally {
				System.out.println("Com exception ou sem o bloco finally é sempre executado\n");

			}
		} while (continua);
	}
}
