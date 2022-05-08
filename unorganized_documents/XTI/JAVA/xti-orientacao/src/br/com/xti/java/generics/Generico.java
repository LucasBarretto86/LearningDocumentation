package br.com.xti.java.generics;

import java.util.ArrayList;

public class Generico<E> {

	E elemento;

	public E getElemento() {
		return elemento;
	}

	public void setElemento(E elemento) {
		this.elemento = elemento;
	}

	public double soma(ArrayList<? extends Number> lista) {
		/*
		 * Metodo generico que recebe uma lista de um elementos genericos usando como
		 * criterio do generics uma validação, neste caso espeificamos o tipo de
		 * generics como sendo todas as classes filhas de Number, que extends Number
		 */

		double total = 0;

		for (Number number : lista) {
			total += number.doubleValue();
		}
		return total;
	}

	/*
	 * public double soma(ArrayList<? super Number> lista){
	 * 
	 * }
	 * 
	 * Um metodo que envetualmente só aceitaria uma lista de classes pais de Number
	 */

	/*
	 * public double soma(ArrayList<? implements Number> lista){
	 * 
	 * }
	 * 
	 * Um metodo que envetualmente só aceitaria uma lista de classes que implementam
	 * Number
	 */

	public static void main(String[] args) {

		Generico<String> g = new Generico<>();

		g.setElemento("Logoa Paranoá");
		System.out.println(g.getElemento());

		System.out.println(g.getElemento().toUpperCase());
	}

}
