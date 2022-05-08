package br.com.xti.java.junit.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CuboTest.class, MatematicaTest.class, RecursividadeTest.class })
public class TestSuite {

}
