package br.com.xti.java.jdbc;

public class Conta {
	private int numero;
	private String cliente;
	private double saldo;
	
	public Conta(int numero, String cliente, double saldo) {
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = saldo;
	}
	
	public String getCliente() {
		return cliente;
	}
	
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public boolean saca(double valor) throws Exception{
		if(valor<=this.saldo) {
			this.saldo-=valor;
			return true;
		}
		throw new Exception();
	}

	public boolean deposita(double valor) throws Exception{
		if(valor>=0) {
			this.saldo+=valor;
			return true;
		}
		throw new Exception();
	}

	public boolean transfere(double valor, Conta destino) {
		try {
			saca(valor);
			destino.deposita(valor);
			return true;
		} catch(Exception e) {
			System.out.println("Saldo insufficiente!");
			return false;
		}
	}
	public String toString() {
		return  new String("Cliente: " + this. cliente +"\tConta: "+ this.numero +"\tSaldo: "+ this.saldo);
	}
	
}
