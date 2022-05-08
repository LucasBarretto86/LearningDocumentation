package br.com.xti.java.junit.test;

import org.junit.Before;
import org.junit.Test;

import br.com.xti.java.avancado.Recursividade;

public class RecursividadeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSoma() {
		Recursividade.soma(10);
	}

}
