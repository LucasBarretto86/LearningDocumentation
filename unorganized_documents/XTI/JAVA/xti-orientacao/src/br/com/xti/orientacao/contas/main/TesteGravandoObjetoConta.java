package br.com.xti.orientacao.contas.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.com.xti.orientacao.contas.model.Conta;

public class TesteGravandoObjetoConta {

	public static void main(String[] args) {

		Conta conta = new Conta();

		conta.setCliente("Juquinha Silva");
		conta.deposita(100_000.25);
		conta.exibirDados();

		try (FileOutputStream fos = new FileOutputStream(
				"E:/Dropbox/_Projects - JAVA/xti-orientacao/files/objetos/contas/contas.ser")) {
			try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(conta);
				oos.close();
				System.out.println("Conta Gravada\n");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileInputStream fis = new FileInputStream(
				"E:/Dropbox/_Projects - JAVA/xti-orientacao/files/objetos/contas/contas.ser")) {
			try (ObjectInputStream ois = new ObjectInputStream(fis)) {
				Conta c1 = (Conta) ois.readObject();
				System.out.println("Conta Carregada\n");
				c1.exibirDados();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}