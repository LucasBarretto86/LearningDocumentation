package br.com.xti.orientacao.animal.main;

import br.com.xti.orientacao.animal.model.Cachorro;
import br.com.xti.orientacao.animal.model.Galinha;

public class TesteHeranca {

	public static void main(String[] args) {

		Cachorro rex = new Cachorro();

		rex.dorme();
		rex.late();

		Galinha lili = new Galinha();

		lili.dorme();
		lili.bota();

		rex.fazBarulho();
		lili.fazBarulho();

	}

}
