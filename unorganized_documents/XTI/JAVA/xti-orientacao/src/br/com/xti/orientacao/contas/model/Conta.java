package br.com.xti.orientacao.contas.model;

public class Conta implements java.io.Serializable {
	String cliente;
	double saldo;

	public Conta() {

	}

	public Conta(String cliente, double saldo) {
		this.cliente = cliente;
		this.saldo = saldo;
	}

	public void saca(double valor) {
		this.saldo -= valor;
	}

	public void deposita(double valor) {
		this.saldo += valor;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void exibirDados() {
		System.out.println("Nome do Cliente: " + getCliente());
		System.out.println("Saldo: " + getSaldo());
		System.out.println();
	}

	public String toString() {
		return getCliente() + " ; " + getSaldo();
	}

	public void transfere(Conta destino, double valor) {
		this.saca(valor);
		destino.deposita(valor);
	}

}
