package br.com.xti.java.threads;

public class ComprasEmFamilia implements Runnable {

	ContaConjunta conta = new ContaConjunta();

	public static void main(String[] args) {

		ComprasEmFamilia irAsCompras = new ComprasEmFamilia();

		new Thread(irAsCompras, "Pai").start();
		new Thread(irAsCompras, "Mãe").start();
		new Thread(irAsCompras, "Irmão").start();
		new Thread(irAsCompras, "Irmã").start();

	}

	@Override
	public void run() {
		String cliente = Thread.currentThread().getName();

		for (int i = 0; i < 5; i++) {
			conta.sacar(20, cliente);

			if (conta.getSaldo() < 0) {
				System.out.println("Estourou");
			}
		}
	}

}
