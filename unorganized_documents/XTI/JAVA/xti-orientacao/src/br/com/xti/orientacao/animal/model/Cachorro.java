package br.com.xti.orientacao.animal.model;

public final class Cachorro extends Animal {
	public int tamanho;
	public String raca;
	public double peso;

	public Cachorro() {
		super(30, "Ração");
		this.peso = super.peso;
	}

	@Override
	public void fazBarulho() {
		this.late();
	}

	public void late() {
		System.out.println("Au, au, au...");
	}
}
