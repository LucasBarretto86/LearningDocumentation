package br.com.xti.java.avancado;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Recursividade {
	/*
	 * Sendo X = 10, logo return X = 10 + (soma(10-1) = soma(9)), logo return X =19
	 * + (soma(9-1) = soma (8)).... até condição true, e return X = 55
	 */

	public static int soma(int x) {
		if (x == 0) {
			return x;
		} else {
			System.out.println(x);
			return x + soma(x - 1);
		}
	}

	public static int potencia(int x, int elevado) {
		if (elevado == 1) {
			System.out.println(x);
			return x;
		} else {
			int y = x * potencia(x, elevado - 1);
			System.out.println(y);
			return y;
		}
	}

	public static void listar(Path path) {
		if (Files.isRegularFile(path)) {
			System.out.println(path.toAbsolutePath());
		} else {
			System.err.println(path.toAbsolutePath());
			try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
				for (Path p : stream) {
					listar(p);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public static void main(String[] args) {
		// System.out.println(soma(10));
		// potencia(3,4)
		listar(Paths.get("E:/Dropbox/_Projects - JAVA"));
	}
}
