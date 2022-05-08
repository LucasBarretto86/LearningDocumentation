package br.com.xti.java.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class TesteMoverCopiarExcluirArquivo {

	public static void main(String[] args) throws IOException {

		/* CLASSE PATH E FILES */

		/* DIRET�RIOS */
		Path dir = Paths.get("E://Dropbox/_Projects - JAVA/xti-orientacao/files/Novo Diret�rio");
		// Esbelece uma variavel para o caminho e get o endere�o como parametro.

		/* CRIA��O DE DIRET�RIO */
		Files.createDirectory(dir);
		System.out.println("Cria��o de pasta Novo Diret�rio para a vari�vel dir.");
		// Cria o novo diretoryo e faz o sysout do endere�o.

		Files.isDirectory(dir);
		System.out.println(Files.isDirectory(dir));
		// Verifica��o boolean se path declarado trata-se ou n�o de um diret�rio, caso
		// seja incluido no path um
		// um arquivo o sistema tras false.

		/* EXCLUS�O DE DIRET�RIO */
		Files.deleteIfExists(dir);
		System.out.println("Deletou a pasta, Novo Direr�tio da vari�vel dir.\n");
		// Deleta o diret�rio especificado na variavel dir, por�m, se o diret�rio tiver
		// arquivos n�o deleta.

		/* ARQUIVO */
		Path path = Paths.get("E://Dropbox/_Projects - JAVA/xti-orientacao/files/cria��o/Novo Arquivo.txt");
		Files.createDirectories(path.getParent());
		// Esbeleceu um path j� com o nome do arquivo e criou todos os diret�rios
		// necess�rios usando o
		// path.Parent()

		/* CRIA��O DE ARQUIVOS */
		Files.createFile(path);
		Files.write(path, "Novo texto!".getBytes());
		System.out.println(path);
		// demanda a cria��o do arquivo e escreve um pequeno texto, apenas para o
		// exemplo, depois imprime o
		// endere�o explicito na variavel path

		/* VERIFICA��O DE ARQUIVO */
		Files.isReadable(path);
		System.out.println(Files.isReadable(path));
		// Verifica��o booleana se o arquivo � ou n�o readable.

		Files.probeContentType(path);
		System.out.println(Files.probeContentType(path));
		// Verifica��o do tipo de arquivo da vari�vel path

		Files.getLastModifiedTime(path);
		System.out.println(Files.getLastModifiedTime(path));
		// Getta o hor�rio da ultima modifia��o do arquivo e a data.

		/* COPIAR ARQUIVO */
		Path copy = Paths.get("E://Dropbox/_Projects - JAVA/xti-orientacao/files/cria��o/Copia.txt");
		// Estabelece um path para cria��o de uma c�pia.

		Files.copy(path, copy, StandardCopyOption.REPLACE_EXISTING);
		// Solicita a copia do arquivo, solicitando como parametro a variavel do arquivo
		// de input e o path
		// do arquivo de output, tamb�m � possivel pedir que o arquivo seja subscrito
		// caso j� exista no campo de
		// options.

		/* MOVER ARQUIVO */
		Path move = Paths.get(path.getParent() + "/move/Novo Arquivo.txt");
		// Estabelece um novo path de destino para o arquivo para mover � necess�rio
		// informar o mesmo nome
		// de arquivo.

		Files.createDirectories(move);
		// Cria o novo diret�rio do path.

		Files.move(path, move, StandardCopyOption.REPLACE_EXISTING);
		// instru��o para a movimenta��o do arquivo

		/* EXCLUS�O DE ARQUIVO */
		Files.deleteIfExists(path);
		Files.deleteIfExists(copy);
		Files.deleteIfExists(copy.getParent());
		// Exclus�o dos arquivos nas duas primeiras linhas e exclus�o do diret�rio via
		// getParent().

	}
}
