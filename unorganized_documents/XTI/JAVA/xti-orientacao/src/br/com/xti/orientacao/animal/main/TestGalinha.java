package br.com.xti.orientacao.animal.main;

import br.com.xti.orientacao.animal.model.Galinha;

public class TestGalinha {

	public static void main(String[] args) {
		Galinha tica = new Galinha();

		tica.bota();
		tica.bota();
		tica.bota();

		System.out.println(tica.ovos);

		Galinha g2 = new Galinha();
		g2.bota();
		g2.bota();

		System.out.println(g2.ovos);
		System.out.println("Ovos da Granja " + Galinha.ovosDaGranja);
		System.out.println("Média " + Galinha.mediaDeOvos(2));

	}

}
