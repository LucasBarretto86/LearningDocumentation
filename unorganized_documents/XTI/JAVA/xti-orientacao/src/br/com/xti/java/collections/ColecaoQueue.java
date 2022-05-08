package br.com.xti.java.collections;

import java.util.LinkedList;
import java.util.Queue;

public class ColecaoQueue {

	public static void main(String[] args) {

		// FIFO - First In First Out
		Queue<String> fila = new LinkedList<>();

		fila.add("Lucas");
		fila.add("Xiao Jiao");
		fila.add("Rafael");
		fila.add("Daniel");
		fila.offer("Eloina");
		System.out.println(fila);

		/* verifica o proximo elemento da fila */
		System.out.println(fila.peek());

		/* remove primeiro elemento da fila */
		fila.poll();
		System.out.println(fila);

		/* outros metodos */

		/* Converte uma Queue para uma LinkedList por case */
		LinkedList<String> f = (LinkedList<String>) fila;

		/* Controle de LinkedList para adicionar como primeiro ou ultimo */
		f.addFirst("Camila");
		f.addLast("Julia");
		System.out.println(f);

		/* Controle de LinkedList para selecionar na lista o primeiro ou ultimo */
		System.out.println(f.peekFirst());
		System.out.println(f.peekLast());

		/* Controle de LinkedList para remover da lista o primeiro ou ultimo */
		f.pollFirst();
		f.pollLast();
		System.out.println(f);

	}

}
