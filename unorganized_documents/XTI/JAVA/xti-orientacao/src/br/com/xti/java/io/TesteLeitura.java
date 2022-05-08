package br.com.xti.java.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TesteLeitura {

	public static void main(String[] args) {

		/* TRATAMENTO LEITURA DE ARQUIVOS EXTENSOS */

		Path path = Paths.get("E://Dropbox/_Projects - JAVA/xti-orientacao/files/arquivo2.txt");
		// Estabelecimento convencional do path do arquivo.

		Charset utf8 = StandardCharsets.UTF_8;
		// Fundamento que se informado qual será o Charset de escrita dentro do package
		// java.nio, o UTF_8 hoje
		// é um dos Charsets mais usados na Web.

		// Usando mecanismo diferenciado de Try/Catch visto que toda tentativa de
		// leitura gera Exception

		try (BufferedReader br = Files.newBufferedReader(path, utf8)) {
			// Usando o novo mecanismo fazemos a criação do obj junto ao try, usando um
			// metodo da classe Files
			// tendo como parametro o path e o charset préviamente estabelecidos.

			String s = null;
			// Estabelece uma variavel String para receber os valores lidos.

			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
			// Cria-se uma condição para o sistema encerre a leitura quando a próxima linha
			// lida se torna null
			// ou seja, não há próxima linha.

		} catch (IOException e) {
			e.printStackTrace();
		}
		// Tratamento normal do catch.

		/* METODO PARA LEITURA ANTES DO JAVA 7 */

		InputStream is = null;
		Scanner input = null;

		try {
			is = new FileInputStream("E://Dropbox/_Projects - JAVA/xti-orientacao/files/arquivo4.txt");
			input = new Scanner(is);

			while (input.hasNextLine()) {
				System.out.println(input);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
