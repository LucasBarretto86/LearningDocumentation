package br.com.xti.java.avancado;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflexao {

	public static void main(String[] args) throws Exception {
		
		/*Estabelece o  path de criação da classe e cria a classe usando-o*/
		String nome = "br.com.xti.orientacao.contas.model.Conta";
		Class classe = Class.forName(nome);
		System.out.println(classe.getSimpleName());
		
		/*Tras todos os fields/atritibutos da classe criada*/
		Field[] f = classe.getFields();
		for (Field atributo : f) {
			System.out.println(atributo);
		}
		/*Tras todos os metodos da classe criada*/
		Method[] m = classe.getDeclaredMethods();
		for (Method metodo : m) {
			System.out.println(metodo);
		}
		/*Trás os construtores da classe*/
		Constructor[] c = classe.getConstructors();
		for (Constructor construtor : c) {
			System.out.println(construtor);
		}
		
		/*Construção de objeto por reflexão*/
		
		/*Definindo Caminho para criação*/
		String origin = "br.com.xti.orientacao.contas.model.Conta";
		Class conta = Class.forName(origin);
		
		/*Estabelece construtor e cria objecto com base neste construtor*/
		Constructor cConstructor = conta.getConstructor(String.class, double.class);
		Object objConta = cConstructor.newInstance("Lucas", 1_000_000.00);
		
		/*Getting métodos*/
		Method deposita = conta.getMethod("deposita", double.class);
		Method getSaldo = conta.getMethod("getSaldo");
		
		/*Usando os médotos*/
		System.out.println(getSaldo.invoke(objConta));
		deposita.invoke(objConta, 120);
		System.out.println(getSaldo.invoke(objConta));	
	}
}
