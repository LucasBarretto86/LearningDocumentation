package br.com.xti.java.threads;

public class ContaConjunta {

	private int saldo = 100;

	public int getSaldo() {
		return saldo;
	}

	public synchronized void sacar(int valor, String cliente) {
		int saldoOriginal = saldo;

		if (saldo >= valor) {
			System.out.println(cliente + " vai sacar");
			try {
				System.out.println(cliente + " aguardando");
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			saldo -= valor;
			String msg = cliente + " SACOU " + valor + " [Saldo Original=" + saldoOriginal + ", Saldo Final=" + saldo
					+ "]";
			System.out.println(msg);
			System.out.println(cliente + " Saque efetuado!");
		} else {
			System.out.println(" saldo insuficiente");
		}
	}
}
