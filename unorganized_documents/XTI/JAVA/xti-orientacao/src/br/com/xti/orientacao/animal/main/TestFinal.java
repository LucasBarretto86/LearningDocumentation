package br.com.xti.orientacao.animal.main;

import br.com.xti.orientacao.animal.model.Cachorro;
import br.com.xti.orientacao.animal.model.Galinha;

public class TestFinal {

	public static void main(String[] args) {

		Cachorro rex = new Cachorro();

		rex.dorme();
		rex.late();
		rex.come();

		Galinha lili = new Galinha();

		lili.dorme();
		lili.bota();
		lili.come();

		rex.fazBarulho();
		lili.fazBarulho();
	}

}
