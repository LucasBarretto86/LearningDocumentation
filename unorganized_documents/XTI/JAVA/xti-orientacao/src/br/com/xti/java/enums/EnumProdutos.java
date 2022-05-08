package br.com.xti.java.enums;

public enum EnumProdutos {

	AGUA(1.20), HOTDOG(3.50), SUCO(3.00), REFRIGERANTE(4.20);

	private double preco;

	EnumProdutos(double preco) {
		this.preco = preco;
	}

	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
