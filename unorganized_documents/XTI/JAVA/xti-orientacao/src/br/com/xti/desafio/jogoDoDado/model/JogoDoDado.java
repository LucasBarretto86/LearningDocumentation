package br.com.xti.desafio.jogoDoDado.model;

/**
 * @author Lucas Baretto
 */

import java.util.Scanner;
import java.util.Random;

public class JogoDoDado {
	private Scanner input;
	private Random random;

	public JogoDoDado() {
		start();
	}

	private void start() {

		int playerNumber = 0;
		int cpuNumber;
		input = new Scanner(System.in);
		random = new Random();

		while (playerNumber > 6 || playerNumber < 1) {
			System.out.println("Inform a number between 1-6: ");
			playerNumber = input.nextInt();
		}
		if (playerNumber > 6 || playerNumber < 1) {
			System.out.println("Numero Invalido");
		} else {
			try {
				Thread.sleep(1000);
				cpuNumber = rollDice();
				if (cpuNumber == playerNumber) {
					System.out.println("You Win");
				} else {
					System.out.println("You Lose, the Right Number Was: " + cpuNumber);
				}

			} catch (InterruptedException i) {

				i.printStackTrace();
			}

		}

	}

	public int rollDice() {
		int randomNumber;
		randomNumber = 1 + random.nextInt(6);
		return randomNumber;
	}

}
