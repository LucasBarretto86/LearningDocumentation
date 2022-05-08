package br.com.xti.java.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TesteEscritaLeituraArquivo {

	public static void main(String[] args) throws IOException {

		/* A PARTIR DO JAVA 7 */

		/* TRATAMENTO DOS CAMINHOS DE ARQUIVOS PRA LEITURA OU ESCRITA */

		Path path = Paths.get("E://Dropbox/_Projects - JAVA/xti-orientacao/files/arquivo.txt");
		// Denomina��o do caminho do arquivo que ser� lido ou escrito.

		path.toAbsolutePath();
		System.out.println(path.toAbsolutePath());
		// Retornando o caminho defindo para o path incluindo o nome do arquivo
		// estabelecido.

		path.getParent();
		System.out.println(path.getParent());
		// Retornando apenas o caminho aonde o arquivo ser� Escrito ou lido.

		path.getRoot();
		System.out.println(path.getRoot());
		// Retornando apenas diret�rio aonde o arquivo ser� escrito ou lido.

		/* CRIA��O DE DIRET�RIOS */

		Files.createDirectories(path.getParent());
		// Criando todos os diret�rios para a escrita de um arquivo, usando a referencia
		// path e o metodo
		// getParent(), tamb�m poderia ser usar o metodo Files.createDirectory() para a
		// cria��o de apenas
		// um unico diret�rio, observe que tentativa de escrita ou leitura gera
		// Exception e requer tratamento
		// neste caso foi lan�ado apenas um thorws para facilitar.

		/* ESCREVER E LER ARQUIVOS */

		/* ESCREVENDO */
		byte[] bytes = "Texto teste".getBytes();
		Files.write(path, bytes);
		// Inicialmente criou-se um Array de bytes, usando uma String com o metodo
		// getByte, pois o Files.write
		// somente aceita o Path estabelecido e uma referencia � uma array de bytes. O
		// metodo da escrita � o
		// File.write(referencia do caminho, referencia do array de bytes).

		/* LENDO */
		byte[] retorno = Files.readAllBytes(path);
		System.out.println(new String(retorno));
		// Para a leitura do arquivo usamos o metodo File.readAllBytes(referencia do
		// caminho) que retorna um array
		// de bytes por isso criamos a referencia retorno, em seguinda foi feito um
		// sysout apenas para imprir no
		// o retorno no console, como detalhe de que criamos uma string usando como
		// parameto o array de bytes.

	}

}
