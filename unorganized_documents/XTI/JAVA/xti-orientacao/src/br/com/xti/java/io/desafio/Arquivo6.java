package br.com.xti.java.io.desafio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

import br.com.xti.orientacao.contas.model.Conta;

public class Arquivo6 {

	public void gravarContas(Collection<Conta> contas) {
		try (FileOutputStream fos = new FileOutputStream(
				"E:/Dropbox/_Projects - JAVA/xti-orientacao/files/arquivo6.ser")) {
			try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(contas);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Gravou");
	}

	public Collection<Conta> carregarContas() throws IOException, ClassNotFoundException {
		try (FileInputStream fis = new FileInputStream(
				"E:/Dropbox/_Projects - JAVA/xti-orientacao/files/arquivo6.ser")) {
			try (ObjectInputStream ois = new ObjectInputStream(fis)) {
				return (Collection<Conta>) ois.readObject();
			}
		}
	}

	public static void main(String[] args) {

		// Collection<Conta> contas = new ArrayList<>();

		// contas.add(new Conta("Ricardo", 12_200));
		// contas.add(new Conta("Lucas", 51_000));
		// contas.add(new Conta("Julio", 400_000));
		// contas.add(new Conta("Allan Kardec", 500_000));
		// contas.add(new Conta("Carlos", 1_000_000));

		Arquivo6 operacao = new Arquivo6();

		// operacao.gravarContas(contas);

		Collection<Conta> contas2;

		try {
			contas2 = operacao.carregarContas();

			for (Conta conta : contas2) {
				conta.exibirDados();
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

}
