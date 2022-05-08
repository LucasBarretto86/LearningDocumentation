package br.com.xti.java.excecoes;

public class TestSenha {

	public static String senha = "123456";

	public static void valida(String senha) throws SenhaInvalidaException {
		if (senha.equals(TestSenha.senha)) {
			System.out.println("Autenticado");
		} else {
			throw new SenhaInvalidaException("Senha Incorreta");

		}
	}

	public static void main(String[] args) {

		try {
			valida("12345");
		} catch (SenhaInvalidaException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

	}
}
