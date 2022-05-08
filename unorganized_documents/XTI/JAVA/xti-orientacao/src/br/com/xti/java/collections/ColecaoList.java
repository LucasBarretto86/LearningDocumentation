package br.com.xti.java.collections;

import java.util.ArrayList;
import java.util.List;

public class ColecaoList {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		list.add("Futebol");
		list.add("Basquete");
		list.add("Volei");
		list.add("T�nis");
		list.add("Nata��o");
		list.add("Boxe");
		list.add("Hockey");
		list.add("Futebol");
		System.out.println(list);

		/* pecorrer e modificar item por item */

		for (int i = 0; i < list.size(); i++) {
			String letra = list.get(i);
			list.set(i, letra.toUpperCase());
		}

		System.out.println(list);

		/* Gerar Lista de item por item */
		for (String s : list) {
			System.out.println(s);
		}

		System.out.println(list.subList(2, 5));
		// estabelece uma sublista dentro da lista, de 2 at� 5, portanto o ultimo item
		// ser� o 4

		System.out.println(list.indexOf("NATA��O"));

		list.subList(2, 5).clear();
		System.out.println(list);

	}

}
