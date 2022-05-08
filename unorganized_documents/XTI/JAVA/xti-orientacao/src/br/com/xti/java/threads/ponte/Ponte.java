package br.com.xti.java.threads.ponte;

public interface Ponte {

	public void set(int valor) throws InterruptedException;

	public int get() throws InterruptedException;

}
