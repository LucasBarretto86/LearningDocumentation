package br.com.xti.java.io.desafio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

import br.com.xti.orientacao.contas.model.Conta;

public class Arquivo5 {

	Path path = Paths.get("E://Dropbox/_Projects - JAVA/xti-orientacao/files/arquivo5.txt");
	Charset utf8 = StandardCharsets.UTF_8;

	public void gravarContas(Collection<Conta> contas) {

		try (BufferedWriter bw = Files.newBufferedWriter(path, utf8)) {
			for (Conta conta : contas) {
				bw.write(conta.toString());

			}
			System.out.println("Gravou");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Collection<Conta> carregarContas() {

		Collection<Conta> contas = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(path, utf8)) {

			String line = null;
			while ((line = br.readLine()) != null) {
				String[] t = line.split(";");
				Conta conta = new Conta(t[0], Double.parseDouble(t[1]));
				contas.add(conta);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

		return contas;
	}

	public static void main(String[] args) {

		/*
		 * Collection<Conta> contas = new ArrayList<>();
		 * 
		 * contas.add(new Conta("Ricardo", 12_200)); contas.add(new Conta("Lucas",
		 * 51_000)); contas.add(new Conta("Julio", 400_000)); contas.add(new
		 * Conta("Allan Kardec", 500_000)); contas.add(new Conta("Carlos", 1_000_000));
		 */

		Arquivo5 operacao = new Arquivo5();

		// operacao.gravarContas(contas);

		Collection<Conta> contas2 = operacao.carregarContas();

		for (Conta conta : contas2) {
			conta.exibirDados();
		}
	}

}
