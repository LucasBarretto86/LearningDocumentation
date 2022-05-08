package br.com.xti.java.junit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.xti.java.interfaces.Cubo;

public class CuboTest {
	Cubo cubo;
	@Before
	public void setUp() throws Exception {
	cubo = new Cubo(10);
	}

	@Test
	public void testCalculaVolume() {
		assertEquals(600, cubo.calculaVolume(),0);
	}

	@Test
	public void testCalculaArea() {
		assertEquals(1000, cubo.calculaArea(), 0);
	}

}
