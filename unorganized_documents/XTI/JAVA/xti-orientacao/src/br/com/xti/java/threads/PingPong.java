package br.com.xti.java.threads;

public class PingPong implements Runnable {

	String palavra;
	long tempo;

	public PingPong(String palavra, long tempo) {
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

		Runnable ping = new PingPong("Ping", 1500);
		Runnable pong = new PingPong("Pong", 2000);

		new Thread(ping, "Ping").start();
		new Thread(pong, "Pong").start();

	}

}
