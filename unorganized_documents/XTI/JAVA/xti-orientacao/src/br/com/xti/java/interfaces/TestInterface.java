package br.com.xti.java.interfaces;

public class TestInterface {

	public static void area(AreaCalculavel objeto) {
		System.out.println(objeto.calculaArea());
	}

	public static void volume(VolumeCalculavel objeto) {
		System.out.println(objeto.calculaVolume());
	}

	public static void main(String[] args) {
		Quadrado quadrado = new Quadrado(2);
		Cubo cubo = new Cubo(2);

		area(quadrado);
		area(cubo);

		volume(new Cubo(4));
		area(new Quadrado(4));

	}
}
