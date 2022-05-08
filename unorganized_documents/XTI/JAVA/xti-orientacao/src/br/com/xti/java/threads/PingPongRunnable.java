package br.com.xti.java.threads;

public class PingPongRunnable extends Thread {

	String palavra;
	long tempo;

	public PingPongRunnable(String palavra, long tempo) {
		this.palavra = palavra;
		this.tempo = tempo;
	}

	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(this.tempo);
				System.out.print(this.palavra + " ");
			}
		} catch (InterruptedException e) {
			return;
		}
	}

	public static void main(String[] args) {

		new PingPongRunnable("Ping", 1500).start();
		new PingPongRunnable("Pong", 2000).start();

		System.out.println("Ver Thread");
	}

}
