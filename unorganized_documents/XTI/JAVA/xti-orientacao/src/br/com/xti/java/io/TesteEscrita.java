package br.com.xti.java.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TesteEscrita {

	public static void main(String[] args) {

		/* TRATAMENTO ESCRITA DE ARQUIVOS EXTENSOS */

		Path path = Paths.get("E://Dropbox/_Projects - JAVA/xti-orientacao/files/arquivo2.txt");
		// Estabelecimento convencional do path do arquivo.

		Charset utf8 = StandardCharsets.UTF_8;
		// Fundamento que se informado qual será o Charset de escrita dentro do package
		// java.nio, o UTF_8 hoje
		// é um dos Charsets mais usados na Web.

		/* METODO PARA ESCRITA A PARTIR DO JAVA 7 */
		// Usando mecanismo diferenciado de Try / Catch visto que toda tentativa de
		// escrita gera Exception

		try (BufferedWriter bw = Files.newBufferedWriter(path, utf8)) {
			// Usando o novo mecanismo fazamos a criação do obj junto ao try, usando um
			// metodo da classe Files
			// tendo como parametro o path e o charset préviamente estabelecidos.

			bw.write("Novo texto de teste\n");
			bw.write("Novo texto de teste\n");
			// comando usado para a inclusão do texto, o metodo write aceita inclusa de
			// ints, arrays e Strings.

		} catch (IOException e) {
			e.printStackTrace();
		}
		// Para efeito de tratamento da Exception.

		/* METODO PARA ESCRITA ANTES DO JAVA 7 COM PRINTSTREAM */

		PrintStream ps = null;
		// Referencia o PrintSream como null, para ter a possibilidade de usa-lo fora do
		// Try, uma vez que será
		// necessário o tratamento da Exception e o uso de finally para fechar o ciclo
		// de escrita de dados.

		try {

			ps = new PrintStream("E://Dropbox/_Projects - JAVA/xti-orientacao/files/Arquivo4.txt");
			// Instancia o PrintStream especificando caminho.

			ps.println("Novo novo novo teste");
			ps.println("Novo novo novo teste");
			ps.println("Novo novo novo teste");
			ps.println("Novo novo novo teste");
			// Insere o texto que será inserido, no ps temos a opção do println.

			ps.flush();
			// Pede para que o ps grave a informação.

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (ps != null) {
				ps.close();
			}
			// Faz com que o sistema feche o ps, caso o mesmo não seja null, ou seja, caso
			// seja executado o try
			// aonde criamos o arquivo no momento em que instanciamos o new PrintStream.
		}

		/* METODO PARA ESCRITA ANTES DO JAVA 7 */

		OutputStream os = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;

		try {
			os = new FileOutputStream("E://Dropbox/_Projects - JAVA/xti-orientacao/files/Arquivo3.txt");
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);

			bw.write("Novo novo teste\n");
			bw.write("Novo novo teste\n");
			bw.write("Novo novo teste\n");
			bw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					os.close();
					osw.close();
					bw.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
