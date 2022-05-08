package br.com.xti.java.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ColecaoMap {

	public static void main(String[] args) {

		/* Map recebe dois paramentros no generics, Map<Tipo, Chave> */
		Map<String, String> pais = new HashMap<>();

		pais.put("BR", "Brasil");
		pais.put("RU", "Russia");
		pais.put("IN", "INDIA");
		pais.put("CH", "CHINA");
		System.out.println(pais);

		/*
		 * Verifica se contem um determinado item usando chave como paramentro,
		 * retornando boolean
		 */
		System.out.println(pais.containsKey("BR"));
		System.out.println(pais.containsKey("US"));

		/*
		 * Verifica se contem um determinado item usando o valor como paramentro,
		 * retornando boolean
		 */
		System.out.println(pais.containsValue("Brasil"));
		System.out.println(pais.containsKey("Azerbajão"));

		/* Seleciona o item informando a chave */
		System.out.println(pais.get("CN"));

		/* Remove item informando a chave */
		pais.remove("RU");
		System.out.println(pais);

		/*
		 * Cria um set para inibir repeticoes de chaves, usando a chave do map como
		 * paramentro
		 */
		Set<String> keys = pais.keySet();

		/*
		 * Percorre o set estabelecido e solicita a impressao de cada valor informando o
		 * Set de chaves
		 */
		for (String key : keys) {
			System.out.println(key + ":" + pais.get(key));
		}

	}

}
