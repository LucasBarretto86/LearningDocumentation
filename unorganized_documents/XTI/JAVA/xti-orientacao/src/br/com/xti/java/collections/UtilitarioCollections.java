package br.com.xti.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UtilitarioCollections {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		list.add("Guaraná");
		list.add("Uva");
		list.add("Manga");
		list.add("Coco");
		list.add("Açai");
		list.add("Banana");
		list.add("Laranja");

		System.out.println(list);

		/* Organiza a Coleção por ordem alfabética */
		Collections.sort(list);
		System.out.println(list);

		/* Inverte a ordem da coleção */
		Collections.reverse(list);
		System.out.println(list);

		/* Tras a coeleção em ordem aleatória */
		Collections.shuffle(list);
		System.out.println(list);

		/* Adiciona novos itens a coleção */
		Collections.addAll(list, "Cupuaçu", "Laranja", "Mamão");
		System.out.println(list);

		/* verifica quantas vezes um item aparece na coleção */
		System.out.println(Collections.frequency(list, "Laranja"));

		/* verificar se itens de uma nova lista distoa da lista original */
		List<String> list2 = Arrays.asList("Acerola", "Graviola");
		boolean d = Collections.disjoint(list, list2);
		System.out.println(d);

		Collections.sort(list);
		System.out.println(list);

		/* informa o index de um item especifico informado como paramentro */
		int index = Collections.binarySearch(list, "Guaraná");
		System.out.println(index);

		/* preenche a lista com item informado como paramentro */
		Collections.fill(list, "Açai");
		System.out.println(list);

	}

}
