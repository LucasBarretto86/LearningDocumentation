package br.com.xti.orientacao.animal.model;

public abstract class Animal {
	String comida;
	double peso;

	public Animal(double peso, String comida) {
		this.peso = peso;
		this.comida = comida;
	}

	public final void come() {
		System.out.println("iaque, iaque");
	}

	public final void dorme() {
		System.out.println("ZZZzzzz");
	}

	public abstract void fazBarulho();

}
