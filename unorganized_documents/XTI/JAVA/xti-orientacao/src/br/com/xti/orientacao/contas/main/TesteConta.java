package br.com.xti.orientacao.contas.main;

import br.com.xti.orientacao.contas.model.Conta;

public class TesteConta {

	public static void main(String[] args) {
		Conta conta1 = new Conta();

		conta1.setCliente("Lucas");
		conta1.deposita(10_000);
		conta1.exibirDados();

		Conta conta2 = new Conta();

		conta2.setCliente("Juca");
		conta2.deposita(9_000);
		conta2.exibirDados();

		conta2.transfere(conta1, 2_000);

		conta1.exibirDados();
		conta2.exibirDados();

		conta1.transfere(conta2, 7_500);

		conta1.exibirDados();
		conta2.exibirDados();

	}

}
