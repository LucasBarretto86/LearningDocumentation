package br.com.xti.orientacao.animal.main;

import br.com.xti.orientacao.animal.model.Cachorro;

public class TestCachorro {

	public static void main(String[] args) {
		Cachorro rex = new Cachorro();

		rex.raca = "vira-lata";
		rex.tamanho = 30;
		rex.late();

		Cachorro tobias = new Cachorro();
		tobias.raca = "vira-lata";
		tobias.tamanho = 40;
		tobias.late();

	}

}
