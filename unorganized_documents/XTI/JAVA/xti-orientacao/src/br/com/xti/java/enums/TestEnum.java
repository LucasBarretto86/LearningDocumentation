package br.com.xti.java.enums;

import br.com.xti.java.constantes.ConstantePI;

public class TestEnum {

	public static void main(String[] args) {

		System.out.println(ConstantePI.PI); // Constante

		System.out.println(EnumPecasDeXadrez.BISPO); // Enum

		System.out.println(EnumMedida.M.titulo);

		for (EnumMedida x : EnumMedida.values()) {
			System.out.println(x + ": " + x.titulo);
		}

		for (EnumProdutos x : EnumProdutos.values()) {

			System.out.println(x + ": R$ " + x.getPreco());
		}

		System.out.println("Mudança de preços:");
		EnumProdutos.SUCO.setPreco(4.20);
		EnumProdutos.REFRIGERANTE.setPreco(5.40);

		for (EnumProdutos x : EnumProdutos.values()) {

			System.out.println(x + ": R$ " + x.getPreco());
		}

	}

}
