package br.com.xti.java.junit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test; 

import br.com.xti.orientacao.matematica.Matematica;

public class MatematicaTest {
	Matematica math;
	@Before
	public void setUp() throws Exception {
		this.math = new Matematica();
	}

	@Test
	public void testMaior() {
		assertEquals(9, math.maior(5, 9));
	}

	@Test
	public void testRaiz() {
		assertEquals(4, math.raiz(16));
	}

	@Test
	public void testDivide() {
		assertEquals(2, math.divide(10, 5));
	}

	@Test
	public void testDividePorZero() {
		/*Erro*/
		assertEquals(2, math.divide(10, 0));
	}
	
	@Test
	public void testDivide4Por2() {
		/*Falha*/
		assertEquals(4, math.divide(4, 2));
	}
	
	
}
