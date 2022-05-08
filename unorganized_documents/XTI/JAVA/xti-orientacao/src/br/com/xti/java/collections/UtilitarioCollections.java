package br.com.xti.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UtilitarioCollections {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		list.add("Guaran�");
		list.add("Uva");
		list.add("Manga");
		list.add("Coco");
		list.add("A�ai");
		list.add("Banana");
		list.add("Laranja");

		System.out.println(list);

		/* Organiza a Cole��o por ordem alfab�tica */
		Collections.sort(list);
		System.out.println(list);

		/* Inverte a ordem da cole��o */
		Collections.reverse(list);
		System.out.println(list);

		/* Tras a coele��o em ordem aleat�ria */
		Collections.shuffle(list);
		System.out.println(list);

		/* Adiciona novos itens a cole��o */
		Collections.addAll(list, "Cupua�u", "Laranja", "Mam�o");
		System.out.println(list);

		/* verifica quantas vezes um item aparece na cole��o */
		System.out.println(Collections.frequency(list, "Laranja"));

		/* verificar se itens de uma nova lista distoa da lista original */
		List<String> list2 = Arrays.asList("Acerola", "Graviola");
		boolean d = Collections.disjoint(list, list2);
		System.out.println(d);

		Collections.sort(list);
		System.out.println(list);

		/* informa o index de um item especifico informado como paramentro */
		int index = Collections.binarySearch(list, "Guaran�");
		System.out.println(index);

		/* preenche a lista com item informado como paramentro */
		Collections.fill(list, "A�ai");
		System.out.println(list);

	}

}
