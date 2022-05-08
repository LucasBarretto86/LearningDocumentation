package br.com.xti.orientacao.carro.main;

import br.com.xti.orientacao.carro.model.Carro;
import br.com.xti.orientacao.carro.model.Motor;

public class TesteCarro {

	public static void main(String[] args) {
		Carro ferrari = new Carro();
		ferrari.setModelo("Enzo");
		ferrari.setVelocidadeMaxima(349);
		ferrari.setSegundosZeroACem(3.2);
		Motor v12 = new Motor();
		v12.setTipo("V12");
		v12.setPotencia(660);
		ferrari.setMotor(v12);

		Carro koenigsegg = new Carro("Koenigsegg CCXR", 430, 3.1);
		koenigsegg.setMotor(new Motor("v8", 1018));

		System.out.println(koenigsegg.getMotor().getPotencia());
	}

}
